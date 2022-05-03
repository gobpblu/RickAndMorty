package com.developer.android.rickandmorty.main.repository

import com.developer.android.rickandmorty.main.model.Result

interface MainRepository {
   suspend fun getResults(): List<Result>
}