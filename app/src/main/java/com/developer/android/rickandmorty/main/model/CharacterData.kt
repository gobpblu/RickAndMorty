package com.developer.android.rickandmorty.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterData(
    val info: Info,
    val heroes: List<Hero>
) : Parcelable
