package com.sdrss.githubtrandingrepoapp.di

import com.sdrss.githubtrandingrepoapp.repository.GithubRepository
import com.sdrss.githubtrandingrepoapp.repository.GithubRepositoryImpl
import org.koin.dsl.module.module

/**
 * @author SDRSS
 */
val repositoryModule = module {
    // Tells Koin how to create an instance of GithubRepository
    factory<GithubRepository> { GithubRepositoryImpl(apiService = get()) }
}



