package com.developer.android.rickandmorty.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.developer.android.rickandmorty.main.model.Hero

@Entity(
    tableName = "characters"
)
data class HeroEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "image") val image: String
    ) {

    fun toCharacter() = Hero(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        image = image
    )

    companion object {
        fun fromCharacterModel(heroes: List<Hero>) =
            heroes.map {
                HeroEntity(
                    id = it.id,
                    name = it.name,
                    status = it.status,
                    species = it.species,
                    gender = it.gender,
                    image = it.image
                )
            }
    }
}
