package android.revesz.seriestracker_v2.data

import androidx.room.*

@Dao
interface SeasonDao {

    @Insert
    fun insertAll(vararg seasons: Season)

    @Query("SELECT * FROM Season")
    fun getAll(): List<Season>

    @Query("SELECT * FROM Season WHERE series_id = :id")
    fun getAllForSeries(id: Int): List<Season>

    @Query("SELECT COUNT(*) FROM Season WHERE series_id = :id")
    fun getSeasonNumberForSeries(id: Int): Int

    @Update
    fun updateSeason(series: Season): Int

    @Delete
    fun delete(season: Season)
}