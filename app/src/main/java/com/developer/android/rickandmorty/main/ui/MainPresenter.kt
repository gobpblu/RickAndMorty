package com.developer.android.rickandmorty.main.ui

import com.developer.android.rickandmorty.common.mvp.BasePresenter
import com.developer.android.rickandmorty.main.api.RickAndMortyApi
import com.developer.android.rickandmorty.main.api.model.CharacterDataResponse
import com.developer.android.rickandmorty.main.interactor.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainPresenter
    (
    private val interactor: MainInteractor
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getHeroList() {
        presenterScope.launch {
            try {
                val data = interactor.getResults()
                view?.showHeroList(data)
            } catch (t: Throwable) {
                Timber.e(t.message)
            }
        }
    }
}