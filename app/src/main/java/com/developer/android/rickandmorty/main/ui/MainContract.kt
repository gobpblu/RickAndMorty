package com.developer.android.rickandmorty.main.ui

import com.developer.android.rickandmorty.common.mvp.BaseFragmentContract
import com.developer.android.rickandmorty.common.mvp.MvpPresenter
import com.developer.android.rickandmorty.common.mvp.MvpView
import com.developer.android.rickandmorty.main.models.character.CharacterData


interface MainContract : BaseFragmentContract {

    interface View : MvpView {
        fun showHeroList(data: CharacterData)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun getHeroList()
    }

}