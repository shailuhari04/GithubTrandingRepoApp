package com.sdrss.githubtrendingrepoapp.repository

import com.sdrss.githubtrendingrepoapp.base.BaseRepository
import com.sdrss.githubtrendingrepoapp.data.remote.api.ApiService
import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse

interface GithubRepository {
    // Suspend is used to await the result from Deferred
    suspend fun fetchData(): MutableList<RepositoriesResponse>?
}

class GithubRepositoryImpl(private val apiService: ApiService) : GithubRepository,
    BaseRepository() {

    //get github trending repositories using safe api call
    override suspend fun fetchData(): MutableList<RepositoriesResponse>? {
        return safeApiCall(
            //await the result of deferred type
            call = { apiService.searchDataAsync().await() },
            error = "Error fetching github trending repositories"
            //convert to mutable list
        )?.toMutableList()
    }
}