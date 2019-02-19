package com.ultim.hub.overhub.ui.wiki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.presentation.wiki.WikiContracts
import com.ultim.hub.overhub.presentation.wiki.WikiPresenter
import com.ultim.hub.overhub.ui.BaseFragment
import javax.inject.Inject


class WikiFragment : BaseFragment(), WikiContracts.View {

    override fun onRetryLoadData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemMenuSelected(numItem: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    @InjectPresenter
    lateinit var wikiPresenter: WikiPresenter

    @ProvidePresenter
    fun providePresenter() = wikiPresenter

    @BindView(R.id.wiki_heroes_button) lateinit var heroButton: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root =  inflater.inflate(R.layout.fragment_wiki, container, false)
        ButterKnife.bind(this, root)
        heroButton.setOnClickListener { wikiPresenter.onHeroButtonClick()}
        return root
    }
}
