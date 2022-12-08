package com.example.raptfinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val STATIONSSIMPLE = "stationssimple"


class StationsFragment : Fragment() {

    private lateinit var stationadapter: StationAdapter
    private lateinit var rcvStations: RecyclerView
    private var stationssimples: ArrayList<StationSimple> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            stationssimples = it.getSerializable(STATIONSSIMPLE) as ArrayList<StationSimple>

        }
        Log.d("StationsFragment", "onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("StationsFragment", "stationssimples.size = ${stationssimples.size}")
        val rootView = inflater.inflate(R.layout.fragment_stations, container, false)
        Log.d("StationsFragment", "onCreateView")
        stationadapter = StationAdapter(stationssimples)

        rcvStations = rootView.findViewById(R.id.f_stations_rcv_stations)
        rcvStations.adapter = stationadapter

        val linearLayoutManager = LinearLayoutManager(context)
        rcvStations.layoutManager = linearLayoutManager

        return rootView

    }

    companion object {

        @JvmStatic
        fun newInstance(stationssimple : ArrayList<StationSimple>) =
            StationsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(STATIONSSIMPLE, stationssimple)

                }

            }

    }
}