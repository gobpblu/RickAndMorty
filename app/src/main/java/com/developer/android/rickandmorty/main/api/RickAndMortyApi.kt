package com.developer.android.rickandmorty.main.api

import com.developer.android.rickandmorty.main.api.model.CharacterDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getResults(
        @Query("page") page: Int
    ): CharacterDataResponse
}