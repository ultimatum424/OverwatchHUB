package com.ultim.hub.overhub.presentation

import com.arellomobile.mvp.MvpView

interface MainContracts {
    interface View: MvpView{
        fun initBottomNavigation(screen: String)

    }
    interface Presenter{
        fun nextScreen(screen: String)
        fun replaceScreen(screen: String)
         fun backScreen()
    }
}