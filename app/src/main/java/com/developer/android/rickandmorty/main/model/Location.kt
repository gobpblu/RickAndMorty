package com.developer.android.rickandmorty.main.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val name: String,
    val url: String
) : Parcelable
