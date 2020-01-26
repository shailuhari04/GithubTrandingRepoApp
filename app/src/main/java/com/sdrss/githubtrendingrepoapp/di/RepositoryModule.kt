package com.sdrss.githubtrendingrepoapp.di

import com.sdrss.githubtrendingrepoapp.repository.GithubRepository
import com.sdrss.githubtrendingrepoapp.repository.GithubRepositoryImpl
import org.koin.dsl.module.module

/**
 * @author SDRSS
 */
val repositoryModule = module {
    // Tells Koin how to create an instance of GithubRepository
    factory<GithubRepository> { GithubRepositoryImpl(apiService = get()) }
}



