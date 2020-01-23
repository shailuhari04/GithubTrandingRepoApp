package com.sdrss.githubtrandingrepoapp.di

import com.sdrss.githubtrandingrepoapp.data.remote.api.ApiService
import org.koin.dsl.module.module
import retrofit2.Retrofit

/**
 * @author SDRSS
 */
val apiModule = module {
    // Tells Koin how to create an instance of SearchAPI
    single(createOnStart = false) { get<Retrofit>().create(ApiService::class.java) }
}



