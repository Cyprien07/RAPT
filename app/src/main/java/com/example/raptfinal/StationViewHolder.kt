package com.example.raptfinal

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StationViewHolder(rootView: View): ViewHolder(rootView) {

    var nom = rootView.findViewById<TextView>(R.id.r_station_nom)
    var icon = rootView.findViewById<ImageView>(R.id.r_station_icon)
    var checkbox = rootView.findViewById<CheckBox>(R.id.r_station_checkBox)
    var btnDetailsStation = rootView.findViewById<ImageView>(R.id.r_station_button)


}