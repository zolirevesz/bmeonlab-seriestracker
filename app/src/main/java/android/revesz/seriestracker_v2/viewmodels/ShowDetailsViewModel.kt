package android.revesz.seriestracker_v2.viewmodels

import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.ViewModel

class ShowDetailsViewModel (private val seriesRepository: SeriesRepository, private val showId: Int): ViewModel(){

    val series = seriesRepository.getShow(showId)

    fun add(series: LocalData) {
        seriesRepository.addShow(series)
    }

    fun update(series: LocalData) {
        seriesRepository.updateShow(series)
    }
}