package com.ultim.hub.overhub.ui

import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.Group
import android.support.v4.app.Fragment
import android.view.ContextMenu
import android.view.View
import android.widget.Button
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.presentation.BaseContracts
import com.ultim.hub.overhub.presentation.BasePresenter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.fragment_sub.view.*
import javax.inject.Inject

abstract class BaseFragment: MvpAppCompatFragment(), HasSupportFragmentInjector, BaseContracts.View {


    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentDispatchingAndroidInjector

    //@InjectPresenter
    //lateinit var basePresenter: BasePresenter

    private lateinit var subView: ConstraintLayout
    private lateinit var errorGroup: Group
    private lateinit var loadingGroup: Group
    private lateinit var retryButton: Button


    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            if (view != null){
                subView = view.findViewById(R.id.sub_view)
                errorGroup = view.findViewById(R.id.sub_fragment_group_error)
                loadingGroup = view.findViewById(R.id.sub_fragment_group_loading)
                retryButton = view.findViewById(R.id.sub_fragment_retry_button)
                retryButton.setOnClickListener { this.onRetryLoadData() }
            }
        } catch (e: Exception){

        }

    }

    override fun showLoading() {
        subView.visibility = View.VISIBLE
        loadingGroup.visibility = View.VISIBLE
        errorGroup.visibility = View.GONE
    }

    override fun showError() {
        subView.visibility = View.VISIBLE
        loadingGroup.visibility = View.GONE
        errorGroup.visibility = View.VISIBLE
    }

    override fun showData() {
        subView.visibility = View.GONE
        loadingGroup.visibility = View.GONE
        errorGroup.visibility = View.GONE
    }
}