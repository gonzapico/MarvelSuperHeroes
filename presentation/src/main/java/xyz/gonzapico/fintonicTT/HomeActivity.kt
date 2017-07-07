package xyz.gonzapico.fintonicTT

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

  val navigator by lazy { app.appComponent.navigator() }


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    setSupportActionBar(toolbar)
    navigator.replaceFragment(this, R.id.frameLayout, SuperHeroesListFragment.newInstance())
  }


  fun getComponent() {
    app.appComponent
  }
}
