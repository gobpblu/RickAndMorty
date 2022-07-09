package com.developer.android.rickandmorty.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.developer.android.rickandmorty.main.db.model.HeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<HeroEntity>>

    @Insert(entity = HeroEntity::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(characters: List<HeroEntity>)
}