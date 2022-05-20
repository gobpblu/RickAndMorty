package com.developer.android.rickandmorty.main.di

import androidx.room.Room
import com.developer.android.rickandmorty.main.interactor.MainInteractor
import com.developer.android.rickandmorty.main.repository.remote.MainRemoteRepository
import com.developer.android.rickandmorty.main.repository.local.MainLocalRepository
import com.developer.android.rickandmorty.main.db.database.AppDatabase
import com.developer.android.rickandmorty.main.ui.MainContract
import com.developer.android.rickandmorty.main.ui.MainPresenter
import com.developer.android.rickandmorty.utils.Constants
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { get<AppDatabase>().getCharactersDao()}
        singleOf(::MainLocalRepository)
        singleOf(::MainRemoteRepository)
        factoryOf(::MainInteractor) bind MainInteractor::class
        singleOf(::MainPresenter) bind MainContract.Presenter::class
        single { Room.databaseBuilder(
            get(),
            AppDatabase::class.java, Constants.TABLE_NAME_CHARACTER
        ).build()}
    }
}