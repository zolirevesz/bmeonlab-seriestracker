package android.revesz.seriestracker_v2.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Date

data class EpisodeResponse(
    val id : Int,
    val episode_number : Int,
    val name : String,
    val overview : String,
    val season_number : Int,

    val air_date : String,
    // season_finale és rating?
    @Embedded
    val season_finale: Boolean
)