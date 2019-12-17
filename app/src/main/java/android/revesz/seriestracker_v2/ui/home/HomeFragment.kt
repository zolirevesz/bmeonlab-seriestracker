package android.revesz.seriestracker_v2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.revesz.seriestracker_v2.R
import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.databinding.FragmentHomeBinding
import android.revesz.seriestracker_v2.ui.allseries.AllSeriesAdapter
import android.revesz.seriestracker_v2.utilities.InjectorUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe

class HomeFragment : Fragment() {
    companion object{
        val testData: LocalData = LocalData(303, "DummyShowX", 1, "Erc", false)
    }
    private val homeViewModel: HomeViewModel by viewModels {
        InjectorUtils.provideHomeViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = AllSeriesAdapter()
        binding.seriesList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: AllSeriesAdapter) {
        if (testData.isAdded) {
            homeViewModel.list.observe(viewLifecycleOwner) { list ->
                adapter.submitList(listOf(testData))
            }
        }
    }
}

