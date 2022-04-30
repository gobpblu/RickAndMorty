package com.developer.android.rickandmorty.main.api

import com.developer.android.rickandmorty.main.models.character.CharacterData
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getAllCharacters(): Call<CharacterData>
}