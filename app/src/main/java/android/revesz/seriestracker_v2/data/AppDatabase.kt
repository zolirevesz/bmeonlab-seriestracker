package android.revesz.seriestracker_v2.data

import android.content.Context
import android.revesz.seriestracker_v2.ioThread
import android.revesz.seriestracker_v2.remote.RemoteServiceInterface
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.GsonBuilder
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

@Database(entities = [LocalData::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun localDataDao(): LocalDataDao

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        val webservice by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(RemoteServiceInterface::class.java)
        }

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "series-db")
                .allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                            GlobalScope.launch(Dispatchers.IO) {
                                val serResponse: SeriesResponse =
                                    webservice.getList(127030, "bcdaca52188a516d75a354990cc5981c")
                                val test: SeriesResponse = webservice.getSeries(65494, "bcdaca52188a516d75a354990cc5981c")
                                val test2: SeriesResponse = webservice.getSeries(82856, "bcdaca52188a516d75a354990cc5981c")
                                val test3: SeriesResponse = webservice.getSeries(1399, "bcdaca52188a516d75a354990cc5981c")
                                val test4: SeriesResponse = webservice.getSeries(69050, "bcdaca52188a516d75a354990cc5981c")
                                getInstance(context).localDataDao().insertAll(
                                    seriesResponseToLocalData(listOf(test, test2, test3, test4))
                                )
                           }
                    }
                })
                .build()
        }

        private fun seriesResponseToLocalData(list: List<SeriesResponse>): List<LocalData> {
            val data: LocalData = LocalData(Random.nextInt(1, 1000), list.get(0).name, list.get(0).number_of_seasons, list.get(0).overview, false, "https://image.tmdb.org/t/p/w600_and_h900_bestv2" + list.get(0).poster_path)
            val data2: LocalData = LocalData(Random.nextInt(1, 1000), list.get(1).name, list.get(1).number_of_seasons, list.get(1).overview, false, "https://image.tmdb.org/t/p/w600_and_h900_bestv2" + list.get(1).poster_path)
            val data3: LocalData = LocalData(Random.nextInt(1, 1000), list.get(2).name, list.get(2).number_of_seasons, list.get(2).overview, false, "https://image.tmdb.org/t/p/w600_and_h900_bestv2" + list.get(2).poster_path)
            val data4: LocalData = LocalData(Random.nextInt(1, 1000), list.get(3).name, list.get(3).number_of_seasons, list.get(3).overview, false, "https://image.tmdb.org/t/p/w600_and_h900_bestv2" + list.get(3).poster_path)
            var localList: List<LocalData> = listOf(data, data2, data3, data4)
            return localList
        }
    }

}