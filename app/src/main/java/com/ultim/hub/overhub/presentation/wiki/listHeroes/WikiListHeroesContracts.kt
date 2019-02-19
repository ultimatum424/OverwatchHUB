package com.ultim.hub.overhub.presentation.wiki.listHeroes

import com.ultim.hub.overhub.presentation.BaseContracts

interface WikiListHeroesContracts {
    interface View: BaseContracts.View{

    }

    interface Presenter: BaseContracts.Presenter{
        fun getHeroesListSize(): Int
        fun getHeroes(): List<WikiListHeroesModel>
    }
}