package com.example.testtaskunsplashapi.ui.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:url")
fun loadImage(view: ImageView?, url: String?) {
    Picasso.get().load(url).into(view)
}