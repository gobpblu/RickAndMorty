package com.developer.android.rickandmorty.main.api.model

import com.google.gson.annotations.SerializedName

data class CharacterDataResponse(
    @SerializedName("info")
    val info: InfoResponse,
    @SerializedName("results")
    val results: List<ResultResponse>
)
