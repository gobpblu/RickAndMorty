package com.developer.android.rickandmorty.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.developer.android.rickandmorty.common.mvp.BaseFragment
import com.developer.android.rickandmorty.main.api.model.ResultResponse
import com.developer.android.rickandmorty.main.model.Result
import com.developer.android.rickandmorty.main.ui.databinding.CharacterBinding

class CharacterFragment(@LayoutRes layoutRes: Int): BaseFragment(layoutRes) {

   private lateinit var binding: CharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getParcelable<com.developer.android.rickandmorty.main.model.Result>("result") as Result
        with (binding) {
            context?.let { Glide.with(it).load(data.image).into(imageViewCharacter) }
            textViewName.text = buildString { append("Name: ${data.name}") }
            textViewGender.text = "Gender: ${data.gender}"
            textViewStatus.text = "Status: ${data.status}"
            textViewSpecies.text = "Species: ${data.species}"
        }
    }
}