package android.revesz.seriestracker_v2.viewmodels

import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SeriesListViewModelFactory (private val repository: SeriesRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = SeriesListViewModel(repository) as T
}