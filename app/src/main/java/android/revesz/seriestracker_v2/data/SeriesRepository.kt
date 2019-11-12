package android.revesz.seriestracker_v2.data

class SeriesRepository private constructor(private val localDataDao: LocalDataDao) {

    fun getSeries() = localDataDao.getAll()

    fun getShow(showId: Int) = localDataDao.getItemByID(showId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: SeriesRepository? = null

        fun getInstance(localDataDao: LocalDataDao) =
            instance ?: synchronized(this) {
                instance ?: SeriesRepository(localDataDao).also { instance = it }
            }
    }
}