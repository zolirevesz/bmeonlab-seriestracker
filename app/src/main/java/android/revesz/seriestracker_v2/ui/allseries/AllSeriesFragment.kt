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

class AllSeriesFragment : Fragment() {

    private lateinit var allSeriesViewModel: AllSeriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allSeriesViewModel =
            ViewModelProviders.of(this).get(AllSeriesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_allseries, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        allSeriesViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}