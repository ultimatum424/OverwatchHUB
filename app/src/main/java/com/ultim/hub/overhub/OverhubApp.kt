package com.ultim.hub.overhub

import android.app.Application
import com.ultim.hub.overhub.dagger.AppComponent
import com.ultim.hub.overhub.dagger.DaggerAppComponent
import com.ultim.hub.overhub.dagger.module.Navig
import com.ultim.hub.overhub.dagger.module.NavigationModule
import dagger.android.AndroidInjector

import dagger.android.DaggerApplication

class OverhubApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}