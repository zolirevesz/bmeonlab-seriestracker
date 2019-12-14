package android.revesz.seriestracker_v2

import android.os.Bundle
import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.databinding.FragmentShowdetailsBinding
import android.revesz.seriestracker_v2.utilities.InjectorUtils
import android.revesz.seriestracker_v2.viewmodels.ShowDetailsViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar

class ShowDetailsFragment : Fragment() {

    private val args: ShowDetailsFragmentArgs by navArgs()

    private val showDetailViewModel: ShowDetailsViewModel by viewModels {
        InjectorUtils.provideShowDetailsViewModelFactory(requireActivity(), args.showId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShowdetailsBinding>(
            inflater, R.layout.fragment_showdetails, container, false
        ).apply {
            viewModel = showDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback {
                override fun add(series: LocalData?) {
                    series?.let {
                        //hideAppBarFab(fab)
                        //showDetailViewModel.addPlantToGarden()
                        Snackbar.make(root, "Show added!", Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }

        return binding.root
    }


    interface Callback {
        fun add(series: LocalData?)
    }
}