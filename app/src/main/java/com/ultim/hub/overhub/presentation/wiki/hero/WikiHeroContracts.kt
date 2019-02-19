package com.ultim.hub.overhub.presentation.wiki.hero

import com.ultim.hub.overhub.presentation.BaseContracts

interface WikiHeroContracts {
    interface View: BaseContracts.View{
        fun loadData(model: WikiHeroModel)
    }

    interface Presenter: BaseContracts.Presenter{

    }
}