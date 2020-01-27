package com.sdrss.githubtrendingrepoapp.ui.main

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sdrss.githubtrendingrepoapp.R
import com.sdrss.githubtrendingrepoapp.custom.view.RobotoRegularTextView
import com.sdrss.githubtrendingrepoapp.utils.gone
import com.sdrss.githubtrendingrepoapp.utils.visible


/**
 * @author SDRSS
 */

@BindingAdapter("refreshing")
fun SwipeRefreshLayout.refreshing(visible: Boolean) {
    isRefreshing = visible
}

@androidx.databinding.BindingAdapter(
    value = ["language", "languageColor", "hasLanguage"],
    requireAll = true
)
fun setBackground(
    view: View,
    language: String?,
    languageColor: String?,
    hasLanguage: Boolean
) {
    if (view is RobotoRegularTextView) {
        if (hasLanguage) {
            language?.let {
                view.text = it
                languageColor?.let { color ->
                    if (color != "") {
                        val colorFinal = if (color.contains("#")) color else "#$color"
                        val fillColor = Color.parseColor(colorFinal)
                        val img: GradientDrawable? = ContextCompat.getDrawable(
                            view.context,
                            R.drawable.ic_circle
                        ) as GradientDrawable
                        img?.setColor(fillColor)
                        view.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
                        view.compoundDrawablePadding = 16
                        view.visible()
                    }
                } ?: run {
                    view.gone()
                }
            } ?: run {
                view.gone()
            }
        }

    }
}


@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context).load(url)
        .placeholder(R.drawable.ic_person_circle_24dp)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}