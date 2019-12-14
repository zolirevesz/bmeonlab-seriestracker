package android.revesz.seriestracker_v2.adapters

import android.revesz.seriestracker_v2.R
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("seasonNumberText")
fun bindWateringText(textView: TextView, seasonNumber: Int) {
    val resources = textView.context.resources
    val quantityString = resources.getQuantityString(
        R.plurals.seasonnumber_text,
        seasonNumber, seasonNumber)

    textView.text = quantityString
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}

@BindingAdapter("isAdded")
fun bindIsAdded(view: FloatingActionButton, isAdded: Boolean?) {
    if (isAdded == null || isAdded) {
        view.hide()
    } else {
        view.show()
    }
}