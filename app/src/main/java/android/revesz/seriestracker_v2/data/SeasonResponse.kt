package android.revesz.seriestracker_v2.data

import java.io.Serializable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class SeasonResponse (
    val episodes : List<EpisodeResponse>,
    val id : Int,
    val name : String,
    val overview : String,
    val season_number : String
)