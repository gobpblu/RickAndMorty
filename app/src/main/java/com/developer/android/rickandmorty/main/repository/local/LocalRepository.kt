package com.developer.android.rickandmorty.main.repository.local

import com.developer.android.rickandmorty.main.model.Hero
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun getHeroes(): Flow<List<Hero>>

    suspend fun insertHeroesToDb(heroes: List<Hero>)
}