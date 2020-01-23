package com.sdrss.githubtrandingrepoapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sdrss.githubtrandingrepoapp.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author SDRSS
 */
private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L
private const val BASE_URL = "https://github-trending-api.now.sh/"

val networkModule = module {

    // Tells Koin how to create an instance of apiService with Retrofit, OkHttpClient, Moshi, MoshiConverterFactory, CoroutineCallAdapterFactory,  instance

    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    single { Moshi.Builder().build() }

    single { MoshiConverterFactory.create(get()) }

    single { CoroutineCallAdapterFactory() }

    single {
        OkHttpClient.Builder().apply {
            cache(get())
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(get())
            addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
        }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .client(get())
            .build()
    }

    single {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().apply {
               //here we can add common headers like auth, Api-key
            }.build())
        }
    }
}
