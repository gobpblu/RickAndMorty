package com.developer.android.rickandmorty.main.ui

import android.os.Bundle
import com.developer.android.rickandmorty.common.mvp.BaseActivity
import com.developer.android.rickandmorty.main.api.RickAndMortyApi
import com.developer.android.rickandmorty.main.ui.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val characterListFragment = CharacterListFragment()
        changeFragment(characterListFragment, R.id.fragment_container)
    }

}