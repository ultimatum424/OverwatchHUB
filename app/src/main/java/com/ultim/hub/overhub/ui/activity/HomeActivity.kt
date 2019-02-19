package com.ultim.hub.overhub.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ultim.hub.overhub.OverhubApp
import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.Screens
import com.ultim.hub.overhub.presentation.MainContracts
import com.ultim.hub.overhub.presentation.HomePresenter
import com.ultim.hub.overhub.ui.fragment.StatisticsFragment
import com.ultim.hub.overhub.ui.fragment.TrackerFragment
import com.ultim.hub.overhub.ui.wiki.WikiFragment
import com.ultim.hub.overhub.ui.wiki.hero.WikiHeroFragment
import com.ultim.hub.overhub.ui.wiki.listHeroes.WikiHeroesListFragment
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject


class HomeActivity : BaseActivity(), MainContracts.View {



    @Inject lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    @InjectPresenter
    lateinit var homePresenter: HomePresenter

    @ProvidePresenter
    fun providePresenter() = homePresenter


    @BindView(R.id.bottom_navigation) lateinit var bottomNavigation: BottomNavigationView


    private val navigator = object : SupportAppNavigator(this, R.id.main_container){

        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = when (screenKey) {
            Screens.AUTH_SCREEN -> Intent(this@HomeActivity, HomeActivity::class.java)
            else -> null
        }

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.TRACKER_SCREEN -> TrackerFragment()
            Screens.STATISTICS_SCREEN -> StatisticsFragment()
            Screens.WIKI_SCREEN -> WikiFragment()
            Screens.WIKI_HEROES_LIST -> WikiHeroesListFragment()
            Screens.WIKI_HERO -> WikiHeroFragment()
            else -> null
        }

        override fun showSystemMessage(message: String?) {
            Toast.makeText(this@HomeActivity, message, Toast.LENGTH_SHORT).show()
        }

        override fun exit() {
            super.exit()
            finish()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initToolbar(false)
        bottomNavigation.setOnNavigationItemSelectedListener(object: BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                if (item.itemId == bottomNavigation.selectedItemId){
                    return false
                }
                when (item.itemId){
                    R.id.menu_statistic -> homePresenter.replaceScreen(Screens.STATISTICS_SCREEN)
                    R.id.menu_wiki -> homePresenter.replaceScreen(Screens.WIKI_SCREEN)
                    R.id.menu_tracker -> homePresenter.replaceScreen(Screens.TRACKER_SCREEN)
                }
                return true
            }
        })

        homePresenter.myCoroutine()
    }

    override fun initBottomNavigation(screen: String) = when(screen) {
        Screens.TRACKER_SCREEN -> bottomNavigation.selectedItemId = R.id.menu_tracker
        Screens.STATISTICS_SCREEN -> bottomNavigation.selectedItemId = R.id.menu_statistic
        Screens.WIKI_SCREEN -> bottomNavigation.selectedItemId = R.id.menu_wiki
        else -> {
            bottomNavigation.selectedItemId = R.id.menu_statistic
        }
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }
}
