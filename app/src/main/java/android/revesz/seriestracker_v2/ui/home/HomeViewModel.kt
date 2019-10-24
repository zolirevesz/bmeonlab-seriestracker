package android.revesz.seriestracker_v2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "These are your TV Shows"
    }
    val text: LiveData<String> = _text
}