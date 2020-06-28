package com.keijumt.pokedex.common.bindingadapter

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import androidx.databinding.BindingAdapter

@BindingAdapter("roundCorner")
fun View.roundCorner(radius: Float) {
    clipToOutline = true
    outlineProvider = RoundOutlineProvider(radius)
}

data class RoundOutlineProvider(val radius: Float) : ViewOutlineProvider() {
    override fun getOutline(view: View, outline: Outline) {
        outline.setRoundRect(
            0,
            0,
            view.width,
            view.height,
            radius
        )
    }
}