package com.sdrss.githubtrandingrepoapp.di

import com.sdrss.githubtrandingrepoapp.viewmodel.GithubTrendingRepoViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * @author SDRSS
 */
val viewModelModule = module {
    // Tells Koin how to create an instance of GithubTrendingRepoViewModel with apiService, repository instance
    viewModel {
        GithubTrendingRepoViewModel(
            apiService = get(),
            repository = get()
        )
    }
}