package com.developer.android.rickandmorty.main.repository

import com.developer.android.rickandmorty.main.api.RickAndMortyApi
import com.developer.android.rickandmorty.main.model.MainConverter
import com.developer.android.rickandmorty.main.model.Result

class MainRemoteRepository(
    private val api: RickAndMortyApi
) : MainRepository {
    override suspend fun getResults(): List<Result> {
        val data = api.getResults()
        return MainConverter.fromNetwork(data)
    }

}