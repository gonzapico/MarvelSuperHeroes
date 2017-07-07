package xyz.gonzapico.domain.interactor

import io.reactivex.Observable
import xyz.gonzapico.domain.SuperHeroesAPIResponse
import xyz.gonzapico.domain.executor.PostExecutionThread
import xyz.gonzapico.domain.executor.ThreadExecutor
import xyz.gonzapico.domain.repository.SuperHeroesRepository
import javax.inject.Inject

/**
 * Created by gfernandez on 6/28/17.
 */

class GetSuperHeroes @Inject constructor(private val mRepository: SuperHeroesRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread) : BaseUseCase<SuperHeroesAPIResponse>(
    threadExecutor, postExecutionThread) {

  internal override fun buildUseCaseObservable(): Observable<SuperHeroesAPIResponse> {
    return this.mRepository.getSuperHeroes()
  }
}


