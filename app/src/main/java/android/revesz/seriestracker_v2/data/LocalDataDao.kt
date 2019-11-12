package android.revesz.seriestracker_v2.data

import androidx.room.*

@Dao
interface LocalDataDao {
    @Insert
    fun insertAll(vararg serieslist: LocalData)

    @Query("SELECT * FROM LocalData")
    fun getAll(): List<LocalData>

    @Query("SELECT * FROM LocalData WHERE id = :id")
    fun getItemByID(id: Int): LocalData

    @Update
    fun updateSeries(series: LocalData): Int

    @Delete
    fun delete(series: LocalData)
}