package com.example.raptfinal

data class Station(
    val nom: String,
    val gares_id: Int,
    val nom_lda: String,
    val mode: String,
    val ligne: String,
    val indice_ligne: String,
    val geo_point_2d: List<Double>,
    val fer: Int,
    val train: Int,
    val rer: Int,
    val metro: Int,
    val tramway: Int,
    val navette: Int,
    val vale: Int,
    var favoris: Boolean

    //icon_station
) : java.io.Serializable