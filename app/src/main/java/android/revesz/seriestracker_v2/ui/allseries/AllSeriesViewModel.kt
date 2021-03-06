package android.revesz.seriestracker_v2.ui.allseries

import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.data.SeriesRepository
import android.revesz.seriestracker_v2.remote.RemoteServiceInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AllSeriesViewModel (private val seriesRepository: SeriesRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All Series Fragment"
    }
    val text: LiveData<String> = _text

    val list: LiveData<List<LocalData>> = seriesRepository.getSeries() as LiveData<List<LocalData>>

    fun add(series: LocalData) {
        seriesRepository.addShow(series)
    }

}