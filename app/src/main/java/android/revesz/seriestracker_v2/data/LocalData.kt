package android.revesz.seriestracker_v2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class LocalData (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "series_name")
    var seriesName: String = "",
    @ColumnInfo(name = "seasons_number")
    var seasonsNumber: Int = 0,
    @ColumnInfo(name = "description")
    var description: String = ""
    // TODO error: Cannot figure out how to save this field into database. You can consider adding a type converter for it.
    //    private java.util.List<android.revesz.seriestracker_v2.data.Season> seasons;
    // @ColumnInfo(name = "seasons")
    // var seasons: List<Season>
) : Serializable

data class Season(
    @ColumnInfo(name = "season_number")
    var seasonNumber: Int = 0,
    @ColumnInfo(name = "description")
    var description: String = "",
    @ColumnInfo(name = "episodes_number")
    var episodesNumber: Int = 0,
    @ColumnInfo(name = "episodes")
    var episodes: List<Episode>
) : Serializable

data class Episode(
    @ColumnInfo(name = "episode_name")
    var episodeName: String = "",
    @ColumnInfo(name = "episode_number")
    var episodeNumber: Int = 0,
    @ColumnInfo(name = "rating")
    var rating: Int = 0,
    @ColumnInfo(name = "season_finale")
    var seasonFinale: Int = 0,
    @ColumnInfo(name = "description")
    var description: String = "",
    @ColumnInfo(name = "air_date")
    var airDate: String = ""
) : Serializable