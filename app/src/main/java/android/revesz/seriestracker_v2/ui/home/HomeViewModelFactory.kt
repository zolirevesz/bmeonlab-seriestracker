package android.revesz.seriestracker_v2.ui.home

import android.revesz.seriestracker_v2.data.SeriesRepository
import android.revesz.seriestracker_v2.ui.allseries.AllSeriesViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeViewModelFactory (private val repository: SeriesRepository
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = HomeViewModel(repository) as T

}