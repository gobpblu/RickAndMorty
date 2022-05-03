package com.developer.android.rickandmorty.main.interactor

import com.developer.android.rickandmorty.main.repository.MainRemoteRepository

class MainInteractor(
    private val remoteRepository: MainRemoteRepository
) {
    suspend fun getResults() = remoteRepository.getResults()
}