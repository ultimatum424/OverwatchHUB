package com.ultim.hub.overhub.presentation

import com.arellomobile.mvp.MvpView

interface BaseContracts {
    interface View: MvpView {
        fun onRetryLoadData()
        fun onItemMenuSelected(numItem: Int)
        fun showLoading()
        fun showError()
        fun showData()
    }
    interface Presenter{

    }
}