package com.ultim.hub.overhub.presentation.tracker

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class TrackerPresenter @Inject constructor(): MvpPresenter<TrackerContract.View>(), TrackerContract.Presenter {


}