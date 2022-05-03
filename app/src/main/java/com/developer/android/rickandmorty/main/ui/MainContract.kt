package com.developer.android.rickandmorty.main.ui

import com.developer.android.rickandmorty.common.mvp.BaseFragmentContract
import com.developer.android.rickandmorty.common.mvp.MvpPresenter
import com.developer.android.rickandmorty.common.mvp.MvpView
import com.developer.android.rickandmorty.main.api.model.CharacterDataResponse
import com.developer.android.rickandmorty.main.model.Result


interface MainContract : BaseFragmentContract {

    interface View : MvpView {
        fun showHeroList(results: List<Result>)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun getHeroList()
    }

}