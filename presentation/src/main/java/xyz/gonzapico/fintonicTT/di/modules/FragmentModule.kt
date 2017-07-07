package xyz.gonzapico.fintonicTT.di.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import xyz.gonzapico.fintonicTT.di.PerFragment

@Module
class FragmentModule(private val fragment: Fragment) {

  @Provides
  @PerFragment
  internal fun fragment(): Fragment {
    return this.fragment
  }
}
