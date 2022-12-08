package com.example.raptfinal

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface StationService {
    //Récupère la liste des stations simple
    @GET("gares")
    fun getStations(): Call<List<StationSimple>>
    //Récupère une station détaillée
    @GET("gares/{id}")
    fun getStation(@Path("id") id: Int): Call<Station>

    @PUT("gares/{id}")
    fun updateStation(@Path("id") id: Int): Call<Station>
}