package xyz.gonzapico.fintonicTT

import xyz.gonzapico.domain.SuperHero

/**
 * Created by gfernandez on 7/5/17.
 */
interface SuperHeroesListView {

  fun renderSuperHeroes(superHeroesList: List<SuperHero>)

  fun showLoading()

  fun hideLoading()

  fun showError(message: String)
}