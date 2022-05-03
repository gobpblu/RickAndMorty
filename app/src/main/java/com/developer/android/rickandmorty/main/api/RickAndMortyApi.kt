package com.developer.android.rickandmorty.main.api

import com.developer.android.rickandmorty.main.api.model.CharacterDataResponse
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun getResults(): CharacterDataResponse
}