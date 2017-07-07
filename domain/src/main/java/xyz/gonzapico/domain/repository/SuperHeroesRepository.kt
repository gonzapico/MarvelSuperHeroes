package xyz.gonzapico.domain.repository

import io.reactivex.Observable
import xyz.gonzapico.domain.SuperHeroesAPIResponse

/**
 * Created by gfernandez on 6/28/17.
 */
interface SuperHeroesRepository {
  fun getSuperHeroes(): Observable<SuperHeroesAPIResponse>
}