package xyz.gonzapico.fintonicTT.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import xyz.gonzapico.data.BuildConfig
import xyz.gonzapico.data.executor.JobExecutor
import xyz.gonzapico.data.repository.SuperHeroesRepositoryImpl
import xyz.gonzapico.data.repository.adapter.RestFactory
import xyz.gonzapico.data.repository.adapter.RetrofitFactory
import xyz.gonzapico.domain.executor.PostExecutionThread
import xyz.gonzapico.domain.executor.ThreadExecutor
import xyz.gonzapico.domain.repository.SuperHeroesRepository
import xyz.gonzapico.fintonicTT.HolviApp
import xyz.gonzapico.fintonicTT.UIThread
import javax.inject.Named
import javax.inject.Singleton

@Module class ApplicationModule(private val application: HolviApp) {

  @Provides @Singleton internal fun provideApplicationContext(): Context {
    return this.application
  }

  @Provides @Singleton internal fun provideThreadExecutor(
      jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

  @Provides @Singleton internal fun providePostExecutionThread(
      uiThread: UIThread): PostExecutionThread {
    return uiThread
  }

  @Provides @Singleton internal fun provideRestFactory(factory: RetrofitFactory): RestFactory {
    return factory
  }

  @Provides @Singleton @Named("ApiUrl") internal fun provideApiUrl(): String {
    return BuildConfig.API_URL
  }

  @Provides @Singleton internal fun provideWeatherRepository(
      weatherRepository: SuperHeroesRepositoryImpl): SuperHeroesRepository {
    return weatherRepository
  }
}
