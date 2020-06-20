package com.keijumt.pokedex.common.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}
