package com.sdrss.githubtrendingrepoapp.ui.main

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sdrss.githubtrendingrepoapp.R
import com.sdrss.githubtrendingrepoapp.utils.gone


/**
 * @author SDRSS
 */

@BindingAdapter("refreshing")
fun SwipeRefreshLayout.refreshing(visible: Boolean) {
    isRefreshing = visible
}

@BindingAdapter(value = ["setBackgroundColor"], requireAll = true)
fun setBackground(view: View, languageColor: String?) {
    languageColor?.let { color ->
        if (color != "") {
            val colorFinal = if (color.contains("#")) color else "#$color"
            val fillColor = Color.parseColor(colorFinal)
            val drawable = GradientDrawable()
            drawable.setColor(fillColor)
            drawable.shape = GradientDrawable.OVAL
            view.background = drawable
        }
    } ?: run {
        view.gone()
    }
}

@androidx.databinding.BindingAdapter(value = ["language", "languageColor"])
fun setBackground(view: View, language: String?, languageColor: String?) {
    language?.let {
        languageColor?.let { color ->
            if (color != "") {
                val colorFinal = if (color.contains("#")) color else "#$color"
                val fillColor = Color.parseColor(colorFinal)
                val drawable = GradientDrawable()
                drawable.setColor(fillColor)
                drawable.shape = GradientDrawable.OVAL
                view.background = drawable
            }
        } ?: run { view.gone() }
    } ?: run { view.gone() }
}


@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context).load(url)
        .placeholder(R.drawable.ic_person_circle_24dp)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}