package com.sdrss.githubtrandingrepoapp

import android.app.Application
import com.sdrss.githubtrandingrepoapp.di.apiModule
import com.sdrss.githubtrandingrepoapp.di.networkModule
import com.sdrss.githubtrandingrepoapp.di.repositoryModule
import com.sdrss.githubtrandingrepoapp.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Apply DI for all modules
        startKoin(
            this, listOf(
                networkModule,
                apiModule,
                viewModelModule,
                repositoryModule
            )
        )
    }
}