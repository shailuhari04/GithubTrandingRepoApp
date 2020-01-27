package com.sdrss.githubtrendingrepoapp.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse
import com.sdrss.githubtrendingrepoapp.repository.GithubRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * @author SDRSS
 */
class GithubTrendingRepoViewModel(val repository: GithubRepository) : ViewModel() {

    val showLoading =
        MutableLiveData<Boolean>() //LiveData for handle SimmerLayout Animation start/stop
    val isLoading =
        ObservableBoolean(true) //ObservableBoolean handle visibility of SwipeRefreshLayout and SimmerLayout
    var isInternetAvailable = ObservableBoolean(false) //observableBoolean for handle internet State

    val githubTrendingRepoLiveData =
        MutableLiveData<MutableList<RepositoriesResponse>>() //live data that will be populated as trendingGitRepo updates

    /**
     *@viewModelScope
     * Create a new Job.
     * Create a coroutine context with the job and the dispatcher.
     * Create a coroutine scope with the coroutine context.
     * Clear our job when the linked activity is destroyed.
     */
    fun fetchData() {
        initializeDataMember()

        //launch the coroutine scope
        viewModelScope.launch {
            val trendingGitRepo: MutableList<RepositoriesResponse>? = repository.fetchData()
            //post the value inside live data
            githubTrendingRepoLiveData.postValue(trendingGitRepo)
        }
    }

    fun sortDataByStar() {
        initializeDataMember()

        viewModelScope.launch {
            val sortResult = githubTrendingRepoLiveData.value?.sortedWith(Comparator { o1, o2 ->
                o1.stars.compareTo(o2.stars)
            })

            githubTrendingRepoLiveData.postValue(sortResult as MutableList<RepositoriesResponse>?)
        }
    }

    //sort Data
    fun sortDataByName() {
        initializeDataMember()

        viewModelScope.launch {
            val sortResult = githubTrendingRepoLiveData.value?.sortedWith(Comparator { o1, o2 ->
                o1.name.compareTo(o2.name)
            })

            githubTrendingRepoLiveData.postValue(sortResult as MutableList<RepositoriesResponse>?)
        }
    }

    private fun initializeDataMember() {
        showLoading.postValue(true) //Show SimmerLayout during the operation on the MAIN (default) thread
        isLoading.set(true)
    }

    //sort Data
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel() // Clear our job when the linked activity is destroyed to avoid memory leaks
    }
}