package com.ultim.hub.overhub.ui.wiki.hero


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.presentation.wiki.hero.WIkiHeroPresenter
import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroContracts
import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroModel
import com.ultim.hub.overhub.ui.BaseFragment
import javax.inject.Inject

class WikiHeroFragment : BaseFragment(), WikiHeroContracts.View {

    @Inject
    @InjectPresenter
    lateinit var presenter: WIkiHeroPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject lateinit var heroDescriptionAdapter: WikiHeroAbilityAdapter
    @Inject lateinit var heroSkillsAdapter: WikiHeroSkillListDescriptionAdapter

    //@BindView(R.id.wiki_hero_card_portrait) lateinit var portrait: ImageView
    @BindView(R.id.wiki_hero_quote) lateinit var quote: TextView
    @BindView(R.id.wiki_hero_history) lateinit var history: TextView
    @BindView(R.id.wiki_hero_base_recycle) lateinit var baseTableRecycle: RecyclerView
    @BindView(R.id.wiki_hero_ability_recycle) lateinit var abilityTableRecycle: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.fragment_wiki_hero, container, false)
        ButterKnife.bind(this, root)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseTableRecycle.isNestedScrollingEnabled = false
        baseTableRecycle.adapter = heroDescriptionAdapter
        baseTableRecycle.layoutManager = LinearLayoutManager(view.context)

        abilityTableRecycle.isNestedScrollingEnabled = false
        abilityTableRecycle.adapter = heroSkillsAdapter
        abilityTableRecycle.layoutManager = LinearLayoutManager(view.context)


    }

    override fun loadData(model: WikiHeroModel) {
        quote.text = model.quote
        history.text = model.history
        heroDescriptionAdapter.reloadData(model.baseDescriptionTable)
        heroSkillsAdapter.reloadData(model.skillTable)
    }

    override fun onRetryLoadData() {
    }

    override fun onItemMenuSelected(numItem: Int) {
    }



}
