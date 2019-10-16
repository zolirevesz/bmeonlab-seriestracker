package android.revesz.seriestracker_v2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Date


@Entity
data class oldEpisode(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "season_id")
    var seasonId: Int = 0,
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

@Entity
data class Episode(
    val id : Int,
    val episode_number : Int,
    val name : String,
    val overview : String,
    val season_number : Int,
    val air_date : String
    // TODO season_finale és rating?
)