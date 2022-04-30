package com.developer.android.rickandmorty.main

import com.developer.android.rickandmorty.main.ui.MainContract
import com.developer.android.rickandmorty.main.ui.MainPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { MainPresenter(get()) } bind MainContract.Presenter::class
    }
}