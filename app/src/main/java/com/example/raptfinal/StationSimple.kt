package com.example.raptfinal

data class StationSimple (
    val nom: String,
    val mode: String,
    val gares_id: Int,
    var favoris: Boolean,
    val geo_point_2d: List<Double>
    //icon_station
) : java.io.Serializable
