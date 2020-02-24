package android.revesz.seriestracker_v2.ui.allseries

import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AllSeriesViewModelFactory (private val repository: SeriesRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = AllSeriesViewModel(repository) as T
}