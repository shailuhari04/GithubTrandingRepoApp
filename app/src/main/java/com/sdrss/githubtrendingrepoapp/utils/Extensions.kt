package com.sdrss.githubtrendingrepoapp.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View

/**
 * Helper Extension Function to check the internet connection
 */
fun Context.isOnline(): Boolean {
    var result = false
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    //Check if Connectivity manager is not NUll
    connectivityManager?.let {
        //We check the type of the connection is available for Internet
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    else -> false
                }
            }
        } else {
            result = connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false
        }
    }
    // Return result by default the value will be false
    return result
}


/**
 * Helper Extension Function to set the visibility visible of view
 */
fun View.visible(
    duration: Int = 0,
    delay: Int = 0,
    listener: AnimatorListenerAdapter? = null,
    onStop: ((Animator?) -> Unit)? = null
) {
    if (duration == 0 || visibility == View.VISIBLE) {
        visibility = View.VISIBLE
        return
    }
    alpha = 0f
    visibility = View.VISIBLE
    animate()
        .alpha(1f)
        .setDuration(duration.toLong())
        .apply {
            if (delay > 0) startDelay = delay.toLong()
            listener?.let { setListener(listener) }
                ?: setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        alpha = 1f
                        onStop?.invoke(animation)
                    }
                })
        }
        .start()
}


/**
 * Helper Extension Function to set the visibility gone of view
 */
fun View.gone(
    duration: Int = 0,
    delay: Int = 0,
    listener: AnimatorListenerAdapter? = null,
    onStop: ((Animator?) -> Unit)? = null
) {
    if (duration == 0 || visibility == View.GONE) {
        visibility = View.GONE
        return
    }
    animate()
        .alpha(0f)
        .setDuration(duration.toLong())
        .apply {
            if (delay > 0) startDelay = delay.toLong()
            listener?.let { setListener(listener) }
                ?: setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        visibility = View.GONE
                        onStop?.invoke(animation)
                    }
                })
        }
        .start()
}