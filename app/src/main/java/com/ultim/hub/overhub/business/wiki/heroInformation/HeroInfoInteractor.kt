package com.ultim.hub.overhub.business.wiki.heroInformation

import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroModel
import io.reactivex.Observable
import io.reactivex.Single

interface HeroInfoInteractor {
    fun getHeroInfo(id: Int): Single<WikiHeroModel>
}