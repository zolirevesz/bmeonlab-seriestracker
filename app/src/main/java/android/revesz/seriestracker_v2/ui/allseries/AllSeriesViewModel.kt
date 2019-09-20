package android.revesz.seriestracker_v2.ui.allseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllSeriesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All Series Fragment"
    }
    val text: LiveData<String> = _text
}