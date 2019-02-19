package com.ultim.hub.overhub.dagger.module

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class Navig {
    private var cicerone: Cicerone<Router> = Cicerone.create()

    var holder: NavigatorHolder = cicerone.navigatorHolder
    var router: Router = cicerone.router
    fun getNavigationHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}