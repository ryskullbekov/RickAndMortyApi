package com.example.rickandmortyaapp

import android.app.Application
import com.example.rickandmortyaapp.data.appmodule.appModule
import com.example.rickandmortyaapp.data.appmodule.repositoriesModule
import com.example.rickandmortyaapp.data.appmodule.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, repositoriesModule, viewModelsModule)
        }
    }
}