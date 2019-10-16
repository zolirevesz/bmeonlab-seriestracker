package android.revesz.seriestracker_v2.ui.allseries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.revesz.seriestracker_v2.R
import kotlinx.android.synthetic.main.fragment_allseries.*

class AllSeriesFragment : Fragment() {

    private val allSeriesViewModel by lazy { ViewModelProviders.of(this)[AllSeriesViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_allseries, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allSeriesViewModel.text.observe(this, Observer {
            text_gallery.text = it
        })
    }
}