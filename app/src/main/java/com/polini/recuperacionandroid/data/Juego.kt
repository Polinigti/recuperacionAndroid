package com.polini.recuperacionandroid.data

data class Juego (
    var id: String="",
    val nombre: String,
    val nota: Double,
    val descripcion: String,
    val consola: String,
    val imagenUrl: String
)
