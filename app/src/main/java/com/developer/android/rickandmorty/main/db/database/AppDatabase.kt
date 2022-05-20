package com.developer.android.rickandmorty.main.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.developer.android.rickandmorty.main.db.dao.CharactersDao
import com.developer.android.rickandmorty.main.db.entities.HeroEntity

@Database(
    version = 1,
    entities = [
        HeroEntity::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getCharactersDao(): CharactersDao

}