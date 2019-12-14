package android.revesz.seriestracker_v2.utilities

import android.content.Context
import android.revesz.seriestracker_v2.data.AppDatabase
import android.revesz.seriestracker_v2.data.SeriesRepository
import android.revesz.seriestracker_v2.viewmodels.SeriesListViewModelFactory
import android.revesz.seriestracker_v2.viewmodels.ShowDetailsViewModelFactory

object InjectorUtils {
    private fun getSeriesRepository(context: Context): SeriesRepository {
        return SeriesRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).localDataDao())
    }

    /*fun provideGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        val repository = getGardenPlantingRepository(context)
        return GardenPlantingListViewModelFactory(repository)
    }*/

    fun provideSeriesListViewModelFactory(context: Context): SeriesListViewModelFactory {
        val repository = getSeriesRepository(context)
        return SeriesListViewModelFactory(repository)
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