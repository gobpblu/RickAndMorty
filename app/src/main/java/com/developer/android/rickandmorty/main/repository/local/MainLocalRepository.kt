package com.developer.android.rickandmorty.main.repository.local

import com.developer.android.rickandmorty.main.db.model.DatabaseConverter
import com.developer.android.rickandmorty.main.db.dao.CharactersDao
import com.developer.android.rickandmorty.main.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainLocalRepository(
    private val charactersDao: CharactersDao
) : LocalRepository {
    override suspend fun getHeroes(): Flow<List<Hero>> {
     val heroes = charactersDao.getAllCharacters()
        return heroes.map { DatabaseConverter.fromDatabase(it) }
    }

    override suspend fun insertHeroesToDb(heroes: List<Hero>) {
        val heroEntities = DatabaseConverter.toDatabase(heroes)
        charactersDao.insertAll(heroEntities)
    }
}