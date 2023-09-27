package item

import jeu.TirageDes
import personnage.Personnage

class Bombe (
    val nombreDeDes : Int,
    val maxDes :Int,
    val nom :String,
    val description :String){

    fun utiliser(cible :Personnage){
        var tirageDes = TirageDes(this.nombreDeDes,this.maxDes)
        var resultat = tirageDes.lance()
        resultat-=cible.calculeDefense()
        if (resultat< 1){
            resultat =1
        }

        // utiliser la protection de la cible
        cible.pointDeVie= cible.pointDeVie-resultat
        print("$resultat")

    }
}