package android.revesz.seriestracker_v2.viewmodels

import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.ViewModel

class ShowDetailsViewModel (seriesRepository: SeriesRepository, private val showId: Int): ViewModel(){

    var isAdded = false
    val series = LocalData(303, "DummyShowX", 1, "Erc", false) // seriesRepository.getShow(showId)
}