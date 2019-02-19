package com.ultim.hub.overhub.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.presentation.statistics.StatisticsContract
import com.ultim.hub.overhub.presentation.statistics.StatisticsPresenter
import com.ultim.hub.overhub.ui.BaseFragment

import javax.inject.Inject


class StatisticsFragment : BaseFragment(), StatisticsContract.View {

    override fun onRetryLoadData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemMenuSelected(numItem: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    @Inject
    @InjectPresenter
    lateinit var statisticsPresenter: StatisticsPresenter

    @ProvidePresenter
    fun providePresenter() = statisticsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root =  inflater.inflate(R.layout.fragment_statistics, container, false)
        ButterKnife.bind(this, root)
        return root
    }
}
