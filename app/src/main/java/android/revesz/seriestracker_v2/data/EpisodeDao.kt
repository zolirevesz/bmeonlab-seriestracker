package android.revesz.seriestracker_v2.data

import androidx.room.*

@Dao
interface EpisodeDao {

    @Insert
    fun insertAll(vararg episodes: Episode)

    @Query("SELECT * FROM Episode")
    fun getAll(): List<Episode>

    @Query("SELECT * FROM Episode WHERE season_number = :season_number")
    fun getAllForSeason(season_number: Int): List<Episode>

    @Update
    fun updateEpisode(episode: Episode): Int

    @Delete
    fun delete(episode: Episode)
}