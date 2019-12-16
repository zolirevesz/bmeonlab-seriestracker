package android.revesz.seriestracker_v2.utilities

import android.content.Context
import android.revesz.seriestracker_v2.data.AppDatabase
import android.revesz.seriestracker_v2.data.SeriesRepository
import android.revesz.seriestracker_v2.ui.allseries.AllSeriesViewModelFactory
import android.revesz.seriestracker_v2.viewmodels.ShowDetailsViewModelFactory

object InjectorUtils {
    private fun getSeriesRepository(context: Context): SeriesRepository {
        return SeriesRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).localDataDao())
    }

    fun provideAllSeriesViewModelFactory(context: Context): AllSeriesViewModelFactory {
        val repository = getSeriesRepository(context)
        return AllSeriesViewModelFactory(repository)
    }

    fun provideShowDetailsViewModelFactory(
        context: Context,
        showId: Int
    ): ShowDetailsViewModelFactory {
        return ShowDetailsViewModelFactory(getSeriesRepository(context),
            //getSeriesRepository(context),
            showId)
    }
}