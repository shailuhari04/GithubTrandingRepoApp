package com.sdrss.githubtrandingrepoapp.base

import android.util.Log
import retrofit2.Response
import java.io.IOException

/**
 * @author SDRSS
 *
 * Create Base Repository to Handle response of ChildRepository as an Output<out T : Any> and
 * return it as response body or errorResponse
 *
 */
open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, error: String): T? {
        val result = repoApiOutput(call, error)
        var output: T? = null
        when (result) {
            is Output.Success ->
                output = result.output
            is Output.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }

    private suspend fun <T : Any> repoApiOutput(
        call: suspend () -> Response<T>,
        error: String
    ): Output<T> {
        val response = call.invoke()
        return if (response.isSuccessful)
            Output.Success(response.body()!!)
        else
            Output.Error(IOException("OOps .. Something went wrong due to  $error"))
    }
}

sealed class Output<out T : Any> {
    data class Success<out T : Any>(val output: T) : Output<T>()
    data class Error(val exception: Exception) : Output<Nothing>()

}