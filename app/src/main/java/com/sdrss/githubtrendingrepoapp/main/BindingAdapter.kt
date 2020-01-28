package com.sdrss.githubtrendingrepoapp.main

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
import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse
import com.sdrss.githubtrendingrepoapp.utils.gone
import com.sdrss.githubtrendingrepoapp.utils.visible


/**
 * @author SDRSS
 */

@BindingAdapter("refreshing")
fun SwipeRefreshLayout.refreshing(visible: Boolean) {
    isRefreshing = visible
}

@BindingAdapter("setExpandedViewVisibility")
fun setExpandedViewVisibility(view: View, item: RepositoriesResponse) {
    view.apply {
        if (item.isExpanded) visible() else gone()
    }
}

@BindingAdapter(value = ["itemOnClick", "childExpandView"], requireAll = true)
fun itemOnClick(view: View, item: RepositoriesResponse, childExpendView: View) {
    view.apply {
        setOnClickListener {
            when (childExpendView.visibility) {
                View.VISIBLE -> {
                    childExpendView.gone() //using extension function setVisibility
                    item.isExpanded = false //update the state
                }
                View.GONE -> {
                    childExpendView.visible() //using extension function setVisibility
                    item.isExpanded = true //update the state
                }
            }
        }
    }
}


@androidx.databinding.BindingAdapter(
    value = ["language", "languageColor"],
    requireAll = true
)
fun setBackground(
    view: View,
    language: String?,
    languageColor: String?
) {
    if (view is RobotoRegularTextView) {
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


@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context).load(url)
        .placeholder(R.drawable.ic_person_circle_24dp)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}