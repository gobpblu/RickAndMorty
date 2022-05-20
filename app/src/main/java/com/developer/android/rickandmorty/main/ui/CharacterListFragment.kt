package com.developer.android.rickandmorty.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.developer.android.rickandmorty.common.mvp.BaseFragmentMvp
import com.developer.android.rickandmorty.details.CharacterFragment
import com.developer.android.rickandmorty.main.model.Hero
import com.developer.android.rickandmorty.main.db.database.AppDatabase
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
        presenter.getHeroes()
        presenter.collectFlowHeroList()
        swipeRefresh.setOnRefreshListener {
            presenter.refresh()
        }
        charactersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        charactersRecyclerView.adapter = adapter
    }

    private fun showDetailsItem(hero: Hero) {
        val fragment = CharacterFragment(R.layout.character)
        val bundle = Bundle()
        bundle.putParcelable("result", hero)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.fragment_container)
    }

    override fun showRefreshing(isRefreshing: Boolean) {
        binding.swipeRefresh.isRefreshing = isRefreshing
    }

    override fun showHeroList(heroes: List<Hero>) {
        adapter.setData(heroes)
    }


    override fun failure(t: Throwable) {
        Timber.e(t.message)
    }

}