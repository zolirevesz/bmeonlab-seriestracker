package android.revesz.seriestracker_v2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
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
    var description: String = "",
    @ColumnInfo(name = "isadded")
    var isAdded: Boolean =  false,
    @ColumnInfo(name = "img")
    var imgPath: String =  ""
) : Serializable

@Entity(foreignKeys = [ForeignKey(entity = LocalData::class,
                                    parentColumns = arrayOf("id"),
                                    childColumns = arrayOf("seriesId"),
                                    onDelete = CASCADE)])
data class Season(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "series_id")
    var seriesId: Int = 0,
    @ColumnInfo(name = "season_number")
    var seasonNumber: Int = 0,
    @ColumnInfo(name = "description")
    var description: String = "",
    @ColumnInfo(name = "episodes_number")
    var episodesNumber: Int = 0
) : Serializable

@Entity(foreignKeys = [ForeignKey(entity = LocalData::class,
                                    parentColumns = arrayOf("id"),
                                    childColumns = arrayOf("seasonId"),
                                    onDelete = CASCADE)])
data class Episode(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "season_id")
    var seasonId: Int = 0,
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

// https://android.jlelse.eu/android-architecture-components-room-relationships-bf473510c14a