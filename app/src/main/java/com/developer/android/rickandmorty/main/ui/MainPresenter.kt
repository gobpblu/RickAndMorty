package com.developer.android.rickandmorty.main.ui

import com.developer.android.rickandmorty.common.mvp.BasePresenter
import com.developer.android.rickandmorty.common.mvp.MvpPresenter
import com.developer.android.rickandmorty.main.api.RickAndMortyApi
import com.developer.android.rickandmorty.main.models.character.CharacterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainPresenter
    (
    private val api: RickAndMortyApi
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    override fun getHeroList() {
        api.getAllCharacters()
            .enqueue(object : Callback<CharacterData> {
                override fun onResponse(
                    call: Call<CharacterData>,
                    response: Response<CharacterData>,
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val characters = response.body()
                        Timber.i(characters.toString())
                        view?.showHeroList(characters!!)

                    }
                }

                override fun onFailure(call: Call<CharacterData>, t: Throwable) {
                    view?.failure(t)
                }
            })
    }
}