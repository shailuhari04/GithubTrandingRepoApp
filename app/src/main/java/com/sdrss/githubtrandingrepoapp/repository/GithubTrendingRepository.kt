package com.sdrss.githubtrandingrepoapp.repository

import com.sdrss.githubtrandingrepoapp.base.BaseRepository
import com.sdrss.githubtrandingrepoapp.data.remote.api.ApiService
import com.sdrss.githubtrandingrepoapp.data.remote.response.RepositoriesResponse

interface GithubRepository {
    // Suspend is used to await the result from Deferred
    suspend fun fetchData(): MutableList<RepositoriesResponse>?
}

class GithubRepositoryImpl(private val apiService: ApiService) : GithubRepository,
    BaseRepository() {

    //get latest news using safe api call
    override suspend fun fetchData(): MutableList<RepositoriesResponse>? {
        return safeApiCall(
            //await the result of deferred type
            call = { apiService.searchData().await() },
            error = "Error fetching github trending repositories"
            //convert to mutable list
        )?.toMutableList()
    }
}