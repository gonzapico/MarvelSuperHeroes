package xyz.gonzapico.data.cloud

import io.reactivex.Observable
import retrofit2.http.GET
import xyz.gonzapico.domain.SuperHeroesAPIResponse

/**
 * Created by gfernandez on 6/28/17.
 */
const val SUPERHEROES_PATH = "bins/bvyob/"

interface WeatherService {

  @GET(SUPERHEROES_PATH)
  fun getWeatherInfoOf(): Observable<SuperHeroesAPIResponse>
}