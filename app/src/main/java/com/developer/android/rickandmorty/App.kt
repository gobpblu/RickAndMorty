package com.developer.android.rickandmorty

import android.app.Application
import com.developer.android.rickandmorty.common.CommonModule
import com.developer.android.rickandmorty.main.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                CommonModule.createRetrofit(),
                MainModule.create()
            )
        }
    }
}