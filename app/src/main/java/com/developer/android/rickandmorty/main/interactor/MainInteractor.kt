package com.developer.android.rickandmorty.main.interactor

import com.developer.android.rickandmorty.main.model.Hero
import com.developer.android.rickandmorty.main.repository.local.MainLocalRepository
import com.developer.android.rickandmorty.main.repository.remote.MainRemoteRepository
import kotlinx.coroutines.flow.Flow

class MainInteractor(
    private val remoteRepository: MainRemoteRepository,
    private val localRepository: MainLocalRepository
) {
    suspend fun getHeroesFromDb(): Flow<List<Hero>> {
        return localRepository.getHeroes()
    }

    suspend fun loadHeroes(page: Int) {
        val heroes = remoteRepository.getResults(page)
        localRepository.insertHeroesToDb(heroes)
    }
}