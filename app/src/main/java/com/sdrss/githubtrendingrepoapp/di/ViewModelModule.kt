package com.sdrss.githubtrendingrepoapp.di

import com.sdrss.githubtrendingrepoapp.ui.main.SearchResultListAdapter
import com.sdrss.githubtrendingrepoapp.viewmodel.GithubTrendingRepoViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * @author SDRSS
 */
val viewModelModule = module {
    // Tells Koin how to create an instance of GithubTrendingRepoViewModel with apiService, repository instance
    viewModel {
        GithubTrendingRepoViewModel(
            repository = get()
        )
    }

    //Tell koin to create and instance of SearchResultListAdapter with viewModel
    single { SearchResultListAdapter() }

}