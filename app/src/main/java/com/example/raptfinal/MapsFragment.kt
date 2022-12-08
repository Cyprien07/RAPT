package com.example.raptfinal

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val STATIONSIMPLES = "stationsimples"
class MapsFragment : Fragment() {
    private lateinit var map: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        map = googleMap;
        map.uiSettings.isCompassEnabled = true

        val paris = LatLng(48.856614, 2.3522219)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 12f))

        arguments?.let {
            val stations = it.getSerializable(STATIONSIMPLES) as ArrayList<StationSimple>
            for (station in stations) {
                val latLng = LatLng(station.geo_point_2d[0],  station.geo_point_2d[1])
                googleMap.addMarker(MarkerOptions().position(latLng).title(station.nom + " (" + station.mode + ")"))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
    companion object {

        @JvmStatic
        fun newInstance(stationsimple : ArrayList<StationSimple>) =
            MapsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(STATIONSIMPLES, stationsimple)

                }
            }

    }
}