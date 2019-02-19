package com.ultim.hub.overhub.presentation.wiki

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.ultim.hub.overhub.OverhubApp
import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.Screens
import com.ultim.hub.overhub.dagger.module.Navig
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class WikiPresenter @Inject constructor(
        private val router: Router
): MvpPresenter<WikiContracts.View>(), WikiContracts.Presenter {

    val list = listOf(WikiMenuModel("КАРТЫ", R.drawable.qwert),
            WikiMenuModel("ГЕРОИ", R.drawable.qwert),
            WikiMenuModel("ПАТЧИ", R.drawable.qwert))



    override fun getWikiMenu(): List<WikiMenuModel> {
        return list
    }

    override fun getWikiMenuSize(): Int = list.size

    override fun onHeroButtonClick() {
        router.navigateTo(Screens.WIKI_HEROES_LIST)
    }
}