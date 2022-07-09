package com.developer.android.rickandmorty.main.repository.remote

import com.developer.android.rickandmorty.main.api.RickAndMortyApi
import com.developer.android.rickandmorty.main.model.MainConverter
import com.developer.android.rickandmorty.main.model.Hero

class MainRemoteRepository(
    private val api: RickAndMortyApi
) : MainRepository {
    override suspend fun getResults(page: Int): List<Hero> {
        val data = api.getResults(page)
        return MainConverter.fromNetwork(data)
    }

}