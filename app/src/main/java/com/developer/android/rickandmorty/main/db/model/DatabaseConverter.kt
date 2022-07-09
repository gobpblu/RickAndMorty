package com.developer.android.rickandmorty.main.db.model

import com.developer.android.rickandmorty.main.model.Hero

object DatabaseConverter {

    fun fromDatabase(heroEntities: List<HeroEntity>) =
        heroEntities.map {
            Hero(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                gender = it.gender,
                image = it.image
            )
        }

    fun toDatabase(heroes: List<Hero>) =
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