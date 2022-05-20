package com.developer.android.rickandmorty.main.model

import com.developer.android.rickandmorty.main.api.model.CharacterDataResponse
import com.developer.android.rickandmorty.main.api.model.LocationResponse
import com.developer.android.rickandmorty.main.api.model.OriginResponse

object MainConverter {
    fun fromNetwork(response: CharacterDataResponse): List<Hero> {
        return response.results.map { result ->
            Hero(
                id = result.id,
                name = result.name,
                status = result.status,
                species = result.species,
                gender = result.gender,
                image = result.image,
            )
        }
    }

    private fun fromNetwork(response: OriginResponse) =
        Origin(
            name = response.name,
            url = response.url
        )

    private fun fromNetwork(response: LocationResponse) =
        Location(
            name = response.name,
            url = response.url
        )
}