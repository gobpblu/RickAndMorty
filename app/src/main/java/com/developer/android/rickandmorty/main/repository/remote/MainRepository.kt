package com.developer.android.rickandmorty.main.repository.remote

import com.developer.android.rickandmorty.main.model.Hero

interface MainRepository {
   suspend fun getResults(page: Int): List<Hero>
}