package android.revesz.seriestracker_v2.ui.home

import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.data.LocalDataDao
import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(private val seriesRepository: SeriesRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "These are your TV Shows"
    }
    val text: LiveData<String> = _text

    var list: LiveData<List<LocalData>> = seriesRepository.getSeries() as LiveData<List<LocalData>>
    //val list: List<LocalData>? = bigList.value?.filter { it.isAdded }

}