package xyz.gonzapico.fintonicTT.di.components

import dagger.Component
import xyz.gonzapico.fintonicTT.WeatherFragment
import xyz.gonzapico.fintonicTT.di.PerFragment
import xyz.gonzapico.fintonicTT.di.modules.FragmentModule

@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class),
    modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
  fun inject(weatherFragment: WeatherFragment)
}
