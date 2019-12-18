package android.revesz.seriestracker_v2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface LocalDataDao {
    @Insert
    fun insertAll(serieslist: List<LocalData>)

    @Insert
    fun insert(series: LocalData)

    @Query("SELECT * FROM LocalData")
    fun getAll(): LiveData<List<LocalData>>

    @Query("SELECT * FROM LocalData WHERE id = :id")
    fun getItemByID(id: Int): LocalData

    @Update
    fun updateSeries(series: LocalData): Int

    @Delete
    fun delete(series: LocalData)
}