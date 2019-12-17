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

                            val seriesList: List<SeriesResponse> =
                                webservice.getList(127030, "bcdaca52188a516d75a354990cc5981c")
                            getInstance(context).localDataDao().insertAll(
                                seriesResponseToLocalData(seriesList)
                            )
                        }
                    }
                })
                .build()
        }

        private fun seriesResponseToLocalData(list: List<SeriesResponse>): List<LocalData> {
            var localList: List<LocalData> = listOf(LocalData(303, "DummyShow", 3, "Abc"))
            //TODO convert response to local data
            return localList
        }
    }

}