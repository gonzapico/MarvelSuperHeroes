package xyz.gonzapico.fintonicTT

import io.reactivex.observers.DisposableObserver
import xyz.gonzapico.domain.SuperHeroesAPIResponse
import xyz.gonzapico.domain.interactor.GetSuperHeroes
import xyz.gonzapico.fintonicTT.di.PerFragment
import javax.inject.Inject

/**
 * Created by gfernandez on 7/5/17.
 */
@PerFragment class WeatherPresenter @Inject constructor(
    private val mGetSuperHeroesUseCase: GetSuperHeroes) {

  lateinit var mSuperHeroesListView: SuperHeroesListView

  fun onAttachView(superHeroesListView: SuperHeroesListView) {
    this.mSuperHeroesListView = superHeroesListView
  }

  private fun requestSuperHeroes() {
    mGetSuperHeroesUseCase.execute(object : DisposableObserver<SuperHeroesAPIResponse>() {
      override fun onNext(superHeroesAPIResponse: SuperHeroesAPIResponse) {
        mSuperHeroesListView.renderSuperHeroes(superHeroesAPIResponse.superheroes)
      }

      override fun onError(e: Throwable) {
        mSuperHeroesListView.showError("Ha ocurrido un error inesperado " + e.message)
      }

      override fun onComplete() {

      }
    })
  }

  fun onDetach() {
    mGetSuperHeroesUseCase.dispose()
    mSuperHeroesListView.to(null)
  }

  fun getSuperHeroes() {
    mSuperHeroesListView.showLoading()
    requestSuperHeroes()
    mSuperHeroesListView.hideLoading()
  }

}
