package android.revesz.seriestracker_v2.ui.allseries

import android.os.Bundle
import android.revesz.seriestracker_v2.MainActivity
import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.databinding.FragmentAllseriesBinding
import android.revesz.seriestracker_v2.ui.home.HomeFragment
import android.revesz.seriestracker_v2.utilities.InjectorUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_allseries.*
import java.time.LocalDateTime
import kotlin.random.Random

class AllSeriesFragment : Fragment() {

    private val allSeriesViewModel: AllSeriesViewModel by viewModels {
        InjectorUtils.provideAllSeriesViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAllseriesBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = AllSeriesAdapter()
        binding.seriesList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allSeriesViewModel.list.observe(this, Observer {
            //series_list.
        })
    }
*/

    private fun subscribeUi(adapter: AllSeriesAdapter) {
        allSeriesViewModel.list.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }


}