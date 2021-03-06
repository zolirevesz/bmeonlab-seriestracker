package android.revesz.seriestracker_v2.adapters

import android.revesz.seriestracker_v2.data.LocalData
import android.revesz.seriestracker_v2.views.MaskedCardView
import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isAdded")
fun bindIsAdded(view: View, isAdded: Boolean) {
    view.visibility = if (isAdded) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("homeIsAdded")
fun bindHomeIsAdded(view: View, isAdded: Boolean) {
    view.visibility = if (isAdded) {
        View.VISIBLE
    } else {
        View.GONE
    }
}