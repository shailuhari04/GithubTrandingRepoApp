package com.sdrss.githubtrendingrepoapp.data.remote.api

import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author SDRSS
 */
interface ApiService {

    @GET("repositories")
    fun searchDataAsync(): Deferred<Response<List<RepositoriesResponse>>>
}