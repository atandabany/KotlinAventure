package personnage

import item.Arme
import item.Armure
import item.Item

class Mage (
    nom:String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    inventaire: MutableList<Item> = mutableListOf(),
    armePrincipale: Arme?,
    armure: Armure?,
    var grimoire : MutableList<Sort> = mutableListOf()

) :Personnage(nom,pointDeVie,pointDeVieMax,attaque,
    defense,endurance,vitesse,inventaire,armePrincipale,armure){


    fun afficheGrimoire(){

    }
    fun choisirEtLancerSort(){

    }

}