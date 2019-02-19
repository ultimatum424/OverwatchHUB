package com.ultim.hub.overhub.presentation.wiki

import com.arellomobile.mvp.MvpView
import com.ultim.hub.overhub.presentation.BaseContracts

interface WikiContracts {
    interface View: MvpView{

    }

    interface Presenter: BaseContracts.Presenter{
        fun getWikiMenuSize(): Int
        fun getWikiMenu(): List<WikiMenuModel>
        fun onHeroButtonClick()
    }

}