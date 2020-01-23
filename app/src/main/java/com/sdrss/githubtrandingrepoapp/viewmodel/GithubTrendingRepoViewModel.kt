package com.sdrss.githubtrandingrepoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sdrss.githubtrandingrepoapp.data.remote.SingleLiveEvent
import com.sdrss.githubtrandingrepoapp.data.remote.response.RepositoriesResponse
import com.sdrss.githubtrandingrepoapp.repository.GithubRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class GithubTrendingRepoViewModel(private val repository: GithubRepository) : ViewModel() {

    val showLoading = MutableLiveData<Boolean>()
    val showError = SingleLiveEvent<String>()

    //create a new Job
    private val parentJob = Job()
    //create a coroutine context with the job and the dispatcher
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    //create a coroutine scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)
    //live data that will be populated as trandingGitRepo updates
    val githubTrendingRepoLiveData = MutableLiveData<MutableList<RepositoriesResponse>>()

    fun fetchData() {
        // Show progressBar during the operation on the MAIN (default) thread
        showLoading.value = true
        ///launch the coroutine scope
        scope.launch {
            val trendingGitRepo: MutableList<RepositoriesResponse>? = repository.fetchData()
            //post the value inside live data
            githubTrendingRepoLiveData.postValue(trendingGitRepo)
            showError.postValue("error")
        }
    }

    fun cancelRequests() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        // Clear our job when the linked activity is destroyed to avoid memory leaks
        parentJob.cancel()
    }

}