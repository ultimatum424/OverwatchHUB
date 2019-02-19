package com.ultim.hub.overhub.dagger.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule{
    private var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(): Router
            = cicerone.router

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder
        = cicerone.navigatorHolder
}