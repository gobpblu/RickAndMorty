package com.developer.android.rickandmorty.main.ui

import com.developer.android.rickandmorty.common.mvp.BaseFragmentContract
import com.developer.android.rickandmorty.common.mvp.MvpPresenter
import com.developer.android.rickandmorty.common.mvp.MvpView
import com.developer.android.rickandmorty.main.model.Hero


interface MainContract : BaseFragmentContract {

    interface View : MvpView {
        fun showRefreshing(isRefreshing: Boolean)
        fun showHeroList(heroes: List<Hero>)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun refresh()
        fun getHeroes(page: Int)
        fun collectFlowHeroList()
    }

}