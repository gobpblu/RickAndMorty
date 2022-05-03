package com.developer.android.rickandmorty.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.developer.android.rickandmorty.common.mvp.BaseFragmentMvp
import com.developer.android.rickandmorty.main.api.model.ResultResponse
import com.developer.android.rickandmorty.main.model.Result
import com.developer.android.rickandmorty.main.ui.databinding.CharactersListBinding
import org.koin.android.ext.android.inject
import timber.log.Timber

class CharacterListFragment : BaseFragmentMvp<MainContract.View, MainContract.Presenter>(R.layout.characters_list),
    MainContract.View {

    override val presenter: MainPresenter by inject()
    private val adapter: MainAdapter by lazy {
        MainAdapter(onClick = { showDetailsItem(it) })
    }

    private lateinit var binding: CharactersListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = CharactersListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        charactersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        charactersRecyclerView.adapter = adapter
        presenter.getHeroList()
        Timber.i("${presenter.getHeroList()}")
    }

    private fun showDetailsItem(result: Result) {
        val fragment = CharacterFragment(R.layout.character)
        val bundle = Bundle()
        bundle.putParcelable("result", result)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.fragment_container)
    }

    override fun showHeroList(results: List<Result>) {
        adapter.setData(results)
    }


    override fun failure(t: Throwable) {
        Timber.e(t.message)
    }


}