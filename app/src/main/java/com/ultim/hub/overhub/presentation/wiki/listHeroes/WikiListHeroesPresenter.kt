package com.ultim.hub.overhub.presentation.wiki.listHeroes

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.ultim.hub.overhub.OverhubApp
import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.Screens
import com.ultim.hub.overhub.dagger.module.Navig
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class WikiListHeroesPresenter @Inject constructor(
        private val router: Router
): MvpPresenter<WikiListHeroesContracts.View>(), WikiListHeroesContracts.Presenter {

    val model = WikiListHeroesModel("D`Va", R.drawable.hero_portrait_simmetra, "#ff519c3f","#22519c3f")
    val model2 = WikiListHeroesModel("Rainghart", R.drawable.hero_portrait_simmetra, "#ff519c3f","#22519c3f")
    val model3 = WikiListHeroesModel("Doomfist", R.drawable.hero_portrait_simmetra, "#ff519c3f","#22519c3f")
    val list = listOf(model3, model2, model, model3, model2, model, model3 )



    override fun getHeroesListSize(): Int {
        return list.size
    }

    override fun getHeroes(): List<WikiListHeroesModel> {
        return list
    }

    fun onClick() {
        router.navigateTo(Screens.WIKI_HERO)

    }
}