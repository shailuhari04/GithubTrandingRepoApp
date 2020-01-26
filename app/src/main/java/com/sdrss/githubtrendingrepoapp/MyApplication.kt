package com.sdrss.githubtrendingrepoapp

import android.app.Application
import com.sdrss.githubtrendingrepoapp.di.apiModule
import com.sdrss.githubtrendingrepoapp.di.networkModule
import com.sdrss.githubtrendingrepoapp.di.repositoryModule
import com.sdrss.githubtrendingrepoapp.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Apply DI for all modules
        startKoin(
            this, listOf(
                networkModule,
                apiModule,
                repositoryModule,
                viewModelModule
                )
        )
    }
}