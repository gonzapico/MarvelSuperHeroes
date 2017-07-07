package xyz.gonzapico.fintonicTT

import android.app.Activity
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by gfernandez on 7/5/17.
 */
val Activity.app: HolviApp
  get() = application as HolviApp

fun ImageView.loadUrl(urlToLoad: String) = Picasso.with(context).load(urlToLoad).into(this)
