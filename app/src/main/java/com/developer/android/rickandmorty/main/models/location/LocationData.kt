package com.developer.android.rickandmorty.main.models.location

import com.google.gson.annotations.SerializedName

data class LocationData(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)
