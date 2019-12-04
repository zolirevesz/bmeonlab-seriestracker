package android.revesz.seriestracker_v2

import android.revesz.seriestracker_v2.data.SeriesRepository

class ShowDetailsViewModel (seriesRepository: SeriesRepository, private val showId: Int){

    val isAdded = true
    val series = seriesRepository.getShow(showId)
}