package com.example.raptfinal

class StationsAdministrator {
    private val stations: HashMap<Int, Station> = HashMap()
    fun addStation(station: Station) {
        stations[station.gares_id] = station
    }
    fun getStation(id: Int): Station? {
        return stations[id]
    }

    fun getAllStations(): ArrayList<Station> {
        return ArrayList(stations.values.sortedBy { it.gares_id })

    }
    fun getStationsOf(nom_ligne: String): List<Station> {
        return stations.filterValues { it.nom_lda.equals(nom_ligne, ignoreCase = true) }
            .values
            .sortedBy { it.nom }
            .toList()
    }
    fun getTotalNumberOfStations(): Int {
        return stations.size
    }
    fun clean() {
        stations.clear()
    }

}