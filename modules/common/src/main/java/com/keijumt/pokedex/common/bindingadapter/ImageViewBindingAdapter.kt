package com.keijumt.pokedex.common.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Glide.with(this)
            .load(it)
            .into(this)
    }
}
