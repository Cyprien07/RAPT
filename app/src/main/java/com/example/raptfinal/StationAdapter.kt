package com.example.raptfinal

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class StationAdapter(private var stationssimples: List<StationSimple>) : RecyclerView.Adapter<StationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {

        val row = LayoutInflater.from(parent.context).inflate(
            R.layout.row_station, parent,
            false
        )

        return StationViewHolder(row)
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val stationsimple = stationssimples[position];
        holder.nom.text = stationsimple.nom.toString()
        Log.d("MainActivity", "stationsSimples : ${stationsimple.favoris}")
        holder.checkbox.isChecked = stationsimple.favoris

        //station.favorite = holder.checkbox.isChecked
        if  (stationsimple.mode  == "METRO") {
            holder.icon.setImageResource(R.drawable.metro)
        } else if (stationsimple.mode == "RER") {
            holder.icon.setImageResource(R.drawable.rer)
        } else if (stationsimple.mode == "TRAM") {
            holder.icon.setImageResource(R.drawable.tram)
        } else if (stationsimple.mode == "TRAIN") {
            holder.icon.setImageResource(R.drawable.train)
        } else if (stationsimple.mode == "NAVETTE"){
            holder.icon.setImageResource(R.drawable.navette)
        } else if (stationsimple.mode == "null"){
            holder.icon.setImageResource(R.drawable.navette)
        }

        holder.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            stationsimple.favoris = !stationsimple.favoris
            Log.d("checkbox", "onCheckedChanged: $isChecked")
            val retrofit = Retrofit.Builder()
                .baseUrl(SERVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(StationService::class.java)
            service.updateStation(stationsimple.gares_id).enqueue(object : Callback<Station> {
                override fun onFailure(call: Call<Station>, t: Throwable) {
                    Log.d("update", "onFailure: ${t.message}")
                }

                override fun onResponse(call: Call<Station>, response: Response<Station>) {
                    Log.d("update", "onResponse: ${response.body()}")
                }
            })
        }



        holder.btnDetailsStation.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_BASE_URL)
                .build()
            val service = retrofit.create(StationService::class.java)

            service.getStation(stationsimple.gares_id).enqueue(object : Callback<Station> {
                override fun onResponse(call: Call<Station>, response: Response<Station>) {

                    val station = response.body()
                    val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                    intent.putExtra("station", station)
                    holder.itemView.context.startActivity(intent)

                }
                override fun onFailure(call: Call<Station>, t: Throwable) {
                    Log.e("Retrofit", "Error while fetching data")
                }
            })
        }

    }



    override fun getItemCount(): Int {
        return stationssimples.size
    }

    fun refreshData(allStations: List<StationSimple>) {
        this.stationssimples = allStations;
    }

}