package com.sdrss.githubtrandingrepoapp.data.remote.api

import com.sdrss.githubtrandingrepoapp.data.remote.response.RepositoriesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author SDRSS
 */
interface ApiService {

    @GET("repositories")
    fun searchData(): Deferred<Response<List<RepositoriesResponse>>>
}