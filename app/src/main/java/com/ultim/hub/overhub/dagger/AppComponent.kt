package com.ultim.hub.overhub.dagger

import android.app.Application
import com.ultim.hub.overhub.dagger.module.AppBindingModule
import com.ultim.hub.overhub.dagger.module.AppModule
import com.ultim.hub.overhub.dagger.module.NavigationModule
import com.ultim.hub.overhub.ui.activity.HomeActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppBindingModule::class, AppModule::class, NavigationModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}