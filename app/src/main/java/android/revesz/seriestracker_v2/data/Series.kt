package android.revesz.seriestracker_v2.data

import java.io.Serializable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class oldSeries(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "series_name")
    var seriesName: String = "",
    @ColumnInfo(name = "seasons_number")
    var seasonsNumber: Int = 0,
    @ColumnInfo(name = "description")
    var description: String = ""
) : Serializable

data class Genre(
    val id: String,
    val name: String
)

@Entity
data class Series(
    val name : String,
    val languages : List<String>,
    val genres: List<Genre>,
    val number_of_seasons : Int,
    val overview : String, //description
    val seasons : List<Season>
)