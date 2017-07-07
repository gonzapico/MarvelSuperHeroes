package xyz.gonzapico.fintonicTT

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.squareup.leakcanary.LeakCanary
import xyz.gonzapico.fintonicTT.di.components.ApplicationComponent
import xyz.gonzapico.fintonicTT.di.components.DaggerApplicationComponent
import xyz.gonzapico.fintonicTT.di.modules.ApplicationModule

/**
 * Created by gfernandez on 7/5/17.
 */

class HolviApp : Application() {

  val appComponent: ApplicationComponent by lazy {
    DaggerApplicationComponent
        .builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }

  override fun onCreate() {
    super.onCreate()
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return
    }
    LeakCanary.install(this)
    // Normal app init code...
    Fresco.initialize(this)
  }
}
