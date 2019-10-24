package android.revesz.seriestracker_v2.ui.allseries

import android.revesz.seriestracker_v2.data.Series
import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllSeriesViewModel internal constructor(seriesRepository: SeriesRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All Series Fragment"
    }
    val text: LiveData<String> = _text

//    val series: LiveData<List<Series>> = seriesRepository.getSeries()

}