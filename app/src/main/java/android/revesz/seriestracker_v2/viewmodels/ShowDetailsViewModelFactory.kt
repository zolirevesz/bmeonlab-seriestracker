package android.revesz.seriestracker_v2.viewmodels

import android.revesz.seriestracker_v2.data.SeriesRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShowDetailsViewModelFactory(
    private val seriesRepository: SeriesRepository,
    private val showId: Int
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShowDetailsViewModel(
            seriesRepository,
            showId
        ) as T
    }
}