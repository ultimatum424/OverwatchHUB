package com.ultim.hub.overhub.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.ultim.hub.overhub.BaseUseCase

import kotlinx.coroutines.experimental.android.UI

import kotlinx.coroutines.experimental.launch

import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class HomePresenter @Inject constructor(
        private val router: Router
) : MvpPresenter<MainContracts.View>(), MainContracts.Presenter {

    init {
    }

    var sq = ""

    var baseUseCase: BaseUseCase = BaseUseCase()

    override fun nextScreen(screen: String)= router.navigateTo(screen)
    override fun replaceScreen(screen: String) = router.replaceScreen(screen)
    override fun backScreen() = router.exit()

    fun myCoroutine() {
       launch(UI) {
           val data = baseUseCase.downloadDataAsync()
           sq = data.toString()
           print(data)
       }
    }




}