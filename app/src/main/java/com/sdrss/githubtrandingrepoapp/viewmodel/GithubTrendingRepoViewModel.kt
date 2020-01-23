package com.sdrss.githubtrandingrepoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.sdrss.githubtrandingrepoapp.data.remote.api.SearchAPI
import com.sdrss.githubtrandingrepoapp.repository.GithubRepository

class GithubTrendingRepoViewModel(val apiService: SearchAPI, val repository: GithubRepository) : ViewModel() {

}