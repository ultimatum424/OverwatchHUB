package com.ultim.hub.overhub.ui.wiki.listHeroes


import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ultim.hub.overhub.utils.ColumnQty

import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.utils.RecycleViewItemSpace
import com.ultim.hub.overhub.presentation.wiki.listHeroes.WikiListHeroesContracts
import com.ultim.hub.overhub.presentation.wiki.listHeroes.WikiListHeroesPresenter
import com.ultim.hub.overhub.ui.BaseFragment
import javax.inject.Inject

class WikiHeroesListFragment : BaseFragment(), WikiListHeroesContracts.View {

    @Inject
    @InjectPresenter
    lateinit var presenter: WikiListHeroesPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @BindView(R.id.wiki_heroes_list_recycle) lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WikHeroListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.fragment_wiki_heroes_list, container, false)
        ButterKnife.bind(this, root)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setHasOptionsMenu(true)
        val t = ColumnQty(view.context, R.layout.wiki_heroes_list_item)
        adapter = WikHeroListAdapter(presenter)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(view.context, t.numberOfColumns) as RecyclerView.LayoutManager?
        recyclerView.addItemDecoration(RecycleViewItemSpace(t.spacing))
    }

    override fun onRetryLoadData() {

    }

    override fun onItemMenuSelected(numItem: Int) {
    }
}
