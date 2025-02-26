package com.sdrss.githubtrendingrepoapp.utils

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
fun View.visible() {
    visibility = View.VISIBLE
    return
}

/**
 * Helper Extension Function to set the visibility invisible of view
 */
fun View.invisible() {
    visibility = View.INVISIBLE
    return
}

/**
 * Helper Extension Function to set the visibility gone of view
 */
fun View.gone() {
    visibility = View.GONE
    return
}
