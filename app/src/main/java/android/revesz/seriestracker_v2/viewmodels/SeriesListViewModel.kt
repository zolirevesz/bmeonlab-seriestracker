package android.revesz.seriestracker_v2.viewmodels

import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SeriesListViewModel internal constructor(seriesRepository: SeriesRepository) : ViewModel() {

    val series: List<LocalData> =
            seriesRepository.getSeries()

}
