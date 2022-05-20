package com.developer.android.rickandmorty.main.ui

import com.developer.android.rickandmorty.common.mvp.BasePresenter
import com.developer.android.rickandmorty.main.interactor.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPresenter
    (
    private val interactor: MainInteractor
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)
    override fun refresh() {
        presenterScope.launch {
            try {
                view?.showRefreshing(isRefreshing = true)
                getHeroes()
                collectFlowHeroList()
            } catch (e: Exception) {
                view?.failure(e)
            } finally {
                view?.showRefreshing(isRefreshing = false)
            }
        }
    }

    override fun getHeroes() {
        presenterScope.launch {
            try {
                interactor.loadHeroes()
            } catch (t: Throwable) {
                Timber.e(t.message)
            }
        }
    }

    override fun collectFlowHeroList() {
        presenterScope.launch {
            interactor.getHeroesFromDb().collect {
                view?.showHeroList(it)
            }
        }
    }
}