package com.sdrss.githubtrandingrepoapp.repository

import com.sdrss.githubtrandingrepoapp.data.remote.api.SearchAPI
import com.sdrss.githubtrandingrepoapp.data.remote.response.RepositoriesResponse
import retrofit2.Response

interface GithubRepository {
    // Suspend is used to await the result from Deferred
    suspend fun getRepository(): NetworkResult<List<RepositoriesResponse>>
}

class GithubRepositoryImpl(private val apiService: SearchAPI) : GithubRepository {
    /*
      We try to return a list of cats from the API
      Await the result from web service and then return it, catching any error from API
      */
    override suspend fun getRepository(): NetworkResult<List<RepositoriesResponse>>  {
        val response = apiService.searchData().await()
        if (response.isSuccessful) {
            val items = response.body()
            if (items != null) {
                return NetworkResult.Success(items)
            }
        }
        return NetworkResult.Failure(response)
    }
}

sealed class NetworkResult<out T> {
    data class Success<T>(val body: T) : NetworkResult<T>()
    data class Failure<T>(val errorResponse: Response<T>? = null) : NetworkResult<T>()
}