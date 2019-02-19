package com.ultim.hub.overhub.dagger.module

import com.ultim.hub.overhub.ui.activity.HomeActivity
import com.ultim.hub.overhub.ui.fragment.StatisticsFragment
import com.ultim.hub.overhub.ui.fragment.TrackerFragment
import com.ultim.hub.overhub.ui.wiki.WikiFragment
import com.ultim.hub.overhub.ui.wiki.hero.WikiHeroFragment
import com.ultim.hub.overhub.ui.wiki.listHeroes.WikiHeroesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindingModule {
    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun bindStatisticsFragment(): StatisticsFragment

    @ContributesAndroidInjector
    abstract fun bindTrackerFragment(): TrackerFragment

    @ContributesAndroidInjector
    abstract fun bindWikiFragment(): WikiFragment

    @ContributesAndroidInjector
    abstract fun bindWikiHeroFragment(): WikiHeroFragment

    @ContributesAndroidInjector
    abstract fun bindWikiHeroesListFragment(): WikiHeroesListFragment
}