package com.example.raptfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
        val station = intent.getSerializableExtra("station") as Station

        this.findViewById<TextView>(R.id.a_detail_txv_nom_lda).text = station.nom_lda
        this.findViewById<TextView>(R.id.a_detail_txv_mode).text = station.mode
        this.findViewById<TextView>(R.id.a_detail_txv_indice_ligne).text = station.indice_ligne
        if (station.fer == 1)
            this.findViewById<TextView>(R.id.a_detail_txv_fer).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_fer).text = "Non"

        if (station.navette == 1)
            this.findViewById<TextView>(R.id.a_detail_txv_nav).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_nav).text = "Non"

        if (station.rer == 1)
            this.findViewById<TextView>(R.id.a_detail_txv_rer).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_rer).text = "Non"

        if (station.tramway == 1)
            this.findViewById<TextView>(R.id.a_detail_txv_tramway).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_tramway).text = "Non"

        if (station.vale ==1)
            this.findViewById<TextView>(R.id.a_detail_txv_vale).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_vale).text = "Non"

        if (station.train == 1)
            this.findViewById<TextView>(R.id.a_detail_txv_train).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_train).text = "Non"

        if (station.metro ==1)
            this.findViewById<TextView>(R.id.a_detail_txv_metro).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_metro).text = "Non"

        if (station.favoris)
            this.findViewById<TextView>(R.id.a_detail_txv_favoris).text = "Oui"
        else
            this.findViewById<TextView>(R.id.a_detail_txv_favoris).text = "Non"



        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar?.title = station.nom
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}