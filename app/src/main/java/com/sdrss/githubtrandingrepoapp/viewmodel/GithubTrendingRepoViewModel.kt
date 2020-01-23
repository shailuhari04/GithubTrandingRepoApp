package com.sdrss.githubtrandingrepoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.sdrss.githubtrandingrepoapp.data.remote.api.SearchAPI
import com.sdrss.githubtrandingrepoapp.repository.GithubTrendingRepository

class GithubTrendingRepoViewModel(val apiService: SearchAPI, val repository: GithubTrendingRepository) : ViewModel() {

}