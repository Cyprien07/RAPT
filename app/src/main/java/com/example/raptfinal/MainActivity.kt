package com.example.raptfinal

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.MapFragment

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val SERVER_BASE_URL = "https://app-df3ace8f-1c36-4933-8878-3737b87d45db.cleverapps.io/"

class MainActivity : AppCompatActivity() {

    private val stationsAdministrator = StationsAdministrator()
    private val stationsSimples : ArrayList<StationSimple> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "je suis rentré")

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SERVER_BASE_URL)
            .build()
        val service = retrofit.create(StationService::class.java)

        service.getStations().enqueue(object : Callback<List<StationSimple>> {
            override fun onResponse(
                call: Call<List<StationSimple>>,
                response: Response<List<StationSimple>>
            ) {

                    Log.d("MainActivity", "je suis rentré de ouuuuuuf")
                    val stations = response.body()
                    if (stations != null) {
                        stationsSimples.addAll(stations)
                        Log.d("MainActivity", "stationsSimples : $stationsSimples")

                        displayStationsFragment()
                }
            }
            override fun onFailure(call: Call<List<StationSimple>>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ${t.message}")
            }
        })




        val tabLayout = findViewById<TabLayout>(R.id.a_main_toolbar)
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        displayStationsFragment()
                    }
                    1 -> {
                        Log.d("o","Je rentre dans map")
                        displayMapFragment()
                    }
                    2 -> {
                        displayInformationsFragment()
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

    }

    private fun displayStationsFragment() {
        val stationsFragment = StationsFragment.newInstance(stationsSimples)
        supportFragmentManager.beginTransaction()
            .replace(R.id.a_main_fragmentlayout, stationsFragment)
            .commit()
    }

    private fun displayInformationsFragment() {
        val informationsFragment = InformationsFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.a_main_fragmentlayout, informationsFragment)
            .commit()

    }
    private fun displayMapFragment() {
        val mapFragment = MapsFragment.newInstance(stationsSimples)
        supportFragmentManager.beginTransaction()
            .replace(R.id.a_main_fragmentlayout, mapFragment)
            .commit()


    }



}
