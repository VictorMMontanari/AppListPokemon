package com.example.applistpokemon

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    val nome: String,
    val descricao: String,
    val type: Type,
    val evolution: List<Evolution>,
    @DrawableRes val imagem: Int
)

data class Type(
    val type1: String,
    val type2: String? = null
)

data class Evolution(
    val name: String,
    @DrawableRes val img: Int
)