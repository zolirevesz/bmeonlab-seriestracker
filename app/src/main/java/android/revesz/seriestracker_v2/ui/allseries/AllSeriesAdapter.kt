package android.revesz.seriestracker_v2.ui.allseries

import android.content.Context
import android.revesz.seriestracker_v2.data.AppDatabase
import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.databinding.ListItemShowsBinding
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class AllSeriesAdapter : ListAdapter<LocalData, RecyclerView.ViewHolder>(SeriesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SeriesViewHolder(ListItemShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val series = getItem(position)
        (holder as SeriesViewHolder).bind(series)
    }

    class SeriesViewHolder(
        private val binding: ListItemShowsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.series?.let { item ->
                    navigateToSeries(item, it)
                }
            }
        }

        private fun navigateToSeries(
            series: LocalData,
            it: View
        ) {
            val direction =
                AllSeriesFragmentDirections.actionNavAllseriesToShowDetailsFragment(
                    series.id
                )
            it.findNavController().navigate(direction)
        }

        fun bind(item: LocalData) {
            binding.apply {
                series = item
                executePendingBindings()
            }
        }
    }

}

private class SeriesDiffCallback : DiffUtil.ItemCallback<LocalData>() {

    override fun areItemsTheSame(oldItem: LocalData, newItem: LocalData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LocalData, newItem: LocalData): Boolean {
        return oldItem == newItem
    }
}