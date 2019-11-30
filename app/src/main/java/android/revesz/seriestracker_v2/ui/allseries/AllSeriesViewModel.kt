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

class AllSeriesViewModel internal constructor(seriesRepository: SeriesRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All Series Fragment"
    }
    val text: LiveData<String> = _text

    private val _list = MutableLiveData<List<LocalData>>()
    val list: LiveData<List<LocalData>> = _list

    // val series: LiveData<List<Series>> = seriesRepository.getSeries()

    //val shows: LiveData<List<SeriesResponse>> = webservice.listSeries()

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(RemoteServiceInterface::class.java)
    }
    // így használd: webservice.

}