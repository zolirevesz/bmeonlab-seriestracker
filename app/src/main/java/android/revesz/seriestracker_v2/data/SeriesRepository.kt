package android.revesz.seriestracker_v2.data

class SeriesRepository private constructor(private val seriesDao: SeriesDao) {

    fun getSeries() = seriesDao.getAll()

    fun getShow(showId: Int) = seriesDao.getItemByID(showId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: SeriesRepository? = null

        fun getInstance(seriesDao: SeriesDao) =
            instance ?: synchronized(this) {
                instance ?: SeriesRepository(seriesDao).also { instance = it }
            }
    }
}