package com.sdrss.githubtrendingrepoapp.main.ui

import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse

object TrendingRepositoryFactory {

    private fun makeTrendingRepository(): RepositoriesResponse {
        return DataFactory.singleRepositoryData()
    }

    fun makeTrendingRepositoryList(count: Int): MutableList<RepositoriesResponse> {
        return (0..count).map { makeTrendingRepository() }.toMutableList()
    }

}