package com.keijumt.pokedex.pokedex.ui.bindingmodel

import androidx.annotation.ColorRes
import com.keijumt.pokedex.resource.R.color as resourceColor

enum class PokemonTypeBindingModel {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY,
    UNKNOWN,
    SHADOW;

    val backgroundColorRes: Int
        @ColorRes
        get() = when (this) {
            NORMAL -> resourceColor.color_normal
            FIGHTING -> resourceColor.color_fighting
            FLYING -> resourceColor.color_flying
            POISON -> resourceColor.color_poison
            GROUND -> resourceColor.color_ground
            ROCK -> resourceColor.color_rock
            BUG -> resourceColor.color_bug
            GHOST -> resourceColor.color_ghost
            STEEL -> resourceColor.color_steel
            FIRE -> resourceColor.color_fire
            WATER -> resourceColor.color_water
            GRASS -> resourceColor.color_grass
            ELECTRIC -> resourceColor.color_electric
            PSYCHIC -> resourceColor.color_psychic
            ICE -> resourceColor.color_ice
            DRAGON -> resourceColor.color_dragon
            DARK -> resourceColor.color_dark
            FAIRY -> resourceColor.color_fairy
            UNKNOWN -> resourceColor.color_unknown
            SHADOW -> resourceColor.color_shadow
        }

    val textColorRes: Int
        @ColorRes
        get() = when (this) {
            NORMAL -> resourceColor.color_on_normal
            FIGHTING -> resourceColor.color_on_fighting
            FLYING -> resourceColor.color_on_flying
            POISON -> resourceColor.color_on_poison
            GROUND -> resourceColor.color_on_ground
            ROCK -> resourceColor.color_on_rock
            BUG -> resourceColor.color_on_bug
            GHOST -> resourceColor.color_on_ghost
            STEEL -> resourceColor.color_on_steel
            FIRE -> resourceColor.color_on_fire
            WATER -> resourceColor.color_on_water
            GRASS -> resourceColor.color_on_grass
            ELECTRIC -> resourceColor.color_on_electric
            PSYCHIC -> resourceColor.color_on_psychic
            ICE -> resourceColor.color_on_ice
            DRAGON -> resourceColor.color_on_dragon
            DARK -> resourceColor.color_on_dark
            FAIRY -> resourceColor.color_on_fairy
            UNKNOWN -> resourceColor.color_on_unknown
            SHADOW -> resourceColor.color_on_shadow
        }
}