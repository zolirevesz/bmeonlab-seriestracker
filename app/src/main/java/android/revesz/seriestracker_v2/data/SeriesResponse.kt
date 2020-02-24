package android.revesz.seriestracker_v2.data

data class Genre(
    val id: String,
    val name: String
)

data class SeriesResponse(
    val name : String,
    val languages : List<String>,
    val genres: List<Genre>,
    val number_of_seasons : Int,
    val overview : String, //description
    val seasons : List<Season>,
    val poster_path: String
)