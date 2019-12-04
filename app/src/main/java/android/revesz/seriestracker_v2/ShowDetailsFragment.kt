package android.revesz.seriestracker_v2

import android.revesz.seriestracker_v2.data.LocalData
import androidx.fragment.app.Fragment

class ShowDetailsFragment : Fragment() {

    interface Callback {
        fun add(series: LocalData?)
    }
}