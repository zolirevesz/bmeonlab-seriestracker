package android.revesz.seriestracker_v2.viewmodels

import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.ViewModel

class ShowDetailsViewModel (seriesRepository: SeriesRepository, private val showId: Int): ViewModel(){

    val isAdded = true
    val series = seriesRepository.getShow(showId)
}