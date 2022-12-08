# RAPT 
![RAPT LOGO](logo_RAPT.png)


## Description
---

L'application RAPT permet à ses utilisateurs de visualiser sur une carte les stations du reseau férré d'ile de France.

L'application se decompose en trois onglets:
- **Liste**  
   Permet de visulaiser sous forme de liste les stations, de les marquer en "Favoris".

- **Map**  
   Permet de visualiser sur une carte interactive les stations. Lors d'un clique sur un marqueur, une page avec plus de détails sur la station s'ouvre.

- **Info**  
   Infos générales sur l'application : 
   - URL des donnees
   - Explications des données affichées
   - Librairies et licences

   

## Données
---
>Les données opendata : 
[cliquer-ici](https://data.opendatasoft.com/explore/dataset/gares-et-stations-du-reseau-ferre-dile-de-france-par-ligne%40hauts-de-seine/)

Les données sont stockées dans un fichier JSON, elles sont chargées dans l'application au démarrage.


## Architecture
---
L'application est développée en Kotlin, avec l'architecture MVVM.

Les librairies utilisées sont les suivantes :
- **Node** : Comme framework JavaScript
- **Retrofit** : pour la gestion des requêtes HTTP
- **Google Maps** : pour la gestion de la carte

## Licences
---
- **Node** : [Github](https://github.com/nodejs/node/blob/main/LICENSE)
- **Retrofit** : [Apache License](https://github.com/square/retrofit/blob/master/LICENSE.txt)
- **Google Maps** : [Google](https://developers.google.com/maps/terms-20180207)


## Auteurs
---
- Cyprien Darmet
- Othman Bargach








