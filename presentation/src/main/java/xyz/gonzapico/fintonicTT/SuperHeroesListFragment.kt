package xyz.gonzapico.fintonicTT

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_weather.*
import xyz.gonzapico.domain.SuperHero
import xyz.gonzapico.fintonicTT.di.components.DaggerFragmentComponent
import xyz.gonzapico.fintonicTT.di.components.FragmentComponent
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SuperHeroesListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SuperHeroesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuperHeroesListFragment : Fragment(), SuperHeroesListView {

  val TAG : String = this.javaClass.canonicalName

  val fragmentComponent: FragmentComponent by lazy {
    DaggerFragmentComponent
        .builder().applicationComponent(activity.app.appComponent).build()
  }

  lateinit var globalView: View

  @Inject
  lateinit var mWeatherPresenter: WeatherPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    fragmentComponent.inject(this)
    globalView = inflater!!.inflate(R.layout.fragment_weather, container, false)
    return globalView
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mWeatherPresenter.onAttachView(this)
  }

  override fun onResume() {
    super.onResume()
    mWeatherPresenter.getSuperHeroes()
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SuperHeroesListFragment.
     */
    fun newInstance(): SuperHeroesListFragment {
      val fragment = SuperHeroesListFragment()
      return fragment
    }
  }

  override fun showLoading() {
    llLoading.visibility = View.VISIBLE
  }

  override fun hideLoading() {
    llLoading.visibility = View.GONE
  }

  override fun showError(message: String) {
    Snackbar.make(globalView, message,
        Snackbar.LENGTH_SHORT).show()
  }

  override fun renderSuperHeroes(superHeroesList: List<SuperHero>) {
    Log.d(TAG, "number of superheroes -> " + superHeroesList.size)
    Log.d(TAG, "first superhero -> " + superHeroesList[0].toString())
  }

  override fun onDestroy() {
    super.onDestroy()
    mWeatherPresenter.onDetach()
  }
}// Required empty public constructor
