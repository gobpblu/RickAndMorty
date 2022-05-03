package com.developer.android.rickandmorty.main.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
) : Parcelable
