package android.revesz.seriestracker_v2.adapters

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