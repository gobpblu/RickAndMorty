package com.developer.android.rickandmorty.main.di

import com.developer.android.rickandmorty.main.interactor.MainInteractor
import com.developer.android.rickandmorty.main.repository.MainRemoteRepository
import com.developer.android.rickandmorty.main.ui.MainContract
import com.developer.android.rickandmorty.main.ui.MainPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { MainPresenter(get()) } bind MainContract.Presenter::class
        factory {
            val interactor = MainInteractor(get())
            interactor
        } bind MainInteractor::class
        single<MainRemoteRepository> { MainRemoteRepository(get()) }

    }
}