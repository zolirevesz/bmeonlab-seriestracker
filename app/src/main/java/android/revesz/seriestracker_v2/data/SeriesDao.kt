package android.revesz.seriestracker_v2.data

import androidx.room.*

@Dao
interface SeriesDao {

    @Insert
    fun insertAll(vararg serieslist: Series)

    @Query("SELECT * FROM Series")
    fun getAll(): List<Series>

    @Query("SELECT * FROM Series WHERE id = :id")
    fun getItemByID(id: Int): Series

    @Update
    fun updateSeries(series: Series): Int

    @Delete
    fun delete(series: Series)
}