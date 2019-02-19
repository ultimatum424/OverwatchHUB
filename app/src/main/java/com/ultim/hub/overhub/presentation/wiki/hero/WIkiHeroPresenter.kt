package com.ultim.hub.overhub.presentation.wiki.hero

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.ultim.hub.overhub.business.wiki.heroInformation.HeroInfoInteractorImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@InjectViewState
@Singleton
class WIkiHeroPresenter @Inject constructor(
        private val heroInfoInteractorImpl: HeroInfoInteractorImpl
): MvpPresenter<WikiHeroContracts.View>(), WikiHeroContracts.Presenter {

    private val compositeDisposable = CompositeDisposable()

    private var model: WikiHeroModel? = null


    init {
        loadData()
    }

    private fun loadData(){
       val disposable: Disposable = heroInfoInteractorImpl.getHeroInfo(0)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(this::handleResult)
        compositeDisposable.add(disposable)
    }

    private fun handleResult(model: WikiHeroModel){
        this.model = model
        viewState.loadData(model)
    }

    fun getBaseDescriptionTable(): List<WikiHeroSkillDescriptionModel> =
            if (model == null) mutableListOf<WikiHeroSkillDescriptionModel>()
            else {
                model!!.baseDescriptionTable
            }

    fun getSkillTable(): List<WikiHeroSkillModel> =
            if (model == null) mutableListOf<WikiHeroSkillModel>()
            else {
                model!!.skillTable
            }
}