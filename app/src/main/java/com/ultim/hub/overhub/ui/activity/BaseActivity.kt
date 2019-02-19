package com.ultim.hub.overhub.ui.activity

import android.support.v7.app.ActionBar
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.ultim.hub.overhub.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity: MvpAppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentDispatchingAndroidInjector

    private lateinit var actionBar: ActionBar

    protected val context: Context
        get() = this


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }


    protected fun initToolbar( isShowing: Boolean = true){
        val toolbar: Toolbar? = findViewById(R.id.toolbar)
        if (toolbar != null){
            setSupportActionBar(toolbar)
            actionBar = this.supportActionBar!!
            if (supportActionBar != null){
                actionBar.setDisplayShowTitleEnabled(true)
                /*
                actionBar.setCustomView(R.layout.spinner)
                actionBar.setDisplayShowCustomEnabled(true)
                actionBar.setDisplayShowTitleEnabled(true)
                actionBar.setDisplayHomeAsUpEnabled(true)
                actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
                 */
                if (!isShowing){
                    actionBar.hide()
                }
            }
        }
    }

    override fun setTitle(titleId: Int) {
        super.setTitle(titleId)
        if (titleId != 0){
            actionBar.setTitle(titleId)
        }
    }
}