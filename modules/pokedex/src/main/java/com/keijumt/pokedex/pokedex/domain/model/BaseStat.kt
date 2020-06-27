package com.keijumt.pokedex.pokedex.domain.model

sealed class BaseStat {
    data class HP(val name: String, val value: Int) : BaseStat()
    data class ATTACK(val name: String, val value: Int) : BaseStat()
    data class DEFENSE(val name: String, val value: Int) : BaseStat()
    data class SPECIAL_ATTACK(val name: String, val value: Int) : BaseStat()
    data class SPECIAL_DEFENCE(val name: String, val value: Int) : BaseStat()
    data class SPEED(val name: String, val value: Int) : BaseStat()
}
