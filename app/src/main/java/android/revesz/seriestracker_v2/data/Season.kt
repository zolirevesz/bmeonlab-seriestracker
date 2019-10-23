package android.revesz.seriestracker_v2.data

import java.io.Serializable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Season(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "series_id")
    var seriesId: Int = 0,
    @ColumnInfo(name = "season_number")
    var seasonNumber: Int = 0,
    @ColumnInfo(name = "description")
    var description: String = ""
) : Serializable

@Entity
data class SeasonResponse (
    val episodes : List<EpisodeResponse>,
    val id : Int,
    val name : String,
    val overview : String,
    val season_number : String
)