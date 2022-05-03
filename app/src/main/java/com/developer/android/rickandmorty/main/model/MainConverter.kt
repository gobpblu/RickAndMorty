package com.developer.android.rickandmorty.main.model

import com.developer.android.rickandmorty.main.api.model.CharacterDataResponse
import com.developer.android.rickandmorty.main.api.model.LocationResponse
import com.developer.android.rickandmorty.main.api.model.OriginResponse

object MainConverter {
    fun fromNetwork(response: CharacterDataResponse): List<Result> {
        return response.results.map { result ->
            Result(
                id = result.id,
                name = result.name,
                status = result.status,
                species = result.species,
                type = result.type,
                gender = result.gender,
                origin = fromNetwork(result.origin),
                location = fromNetwork(result.location),
                image = result.image,
                episode = result.episode,
                url = result.url,
                created = result.created
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