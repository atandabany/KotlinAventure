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

    /**
     *  Méthode pour afficher la liste des Sort du joueur
     *  @author Deva
     */
    fun afficheGrimoire(){

        for (i in 0..grimoire.size-1){
            println("[$i] => ${grimoire[i].nom}")
        }
    }

    /**
     *  Méthode pour choisir un Sort et lancer sur un Cible
     * @param adversaire pour connaitre la cible
     * @author Deva
     */

    fun choisirEtLancerSort(adversaire:Personnage){
        val affiche = afficheGrimoire()

        println("Choisir un sort a lancer (entrez le numéro)")
        var index :Int

        do {
            index = readln().toInt()

        }while (index < 0  || index > grimoire.size-1)


      println("choisir votre cible : [0] => vous-même ou [1] => Adversaire")
        var laCible:Personnage=this;
        var cible = readln().toInt()

        when(cible){
            0 -> laCible = this
            1 -> laCible = adversaire
            else -> print("Erreur")
        }

       val test= this.grimoire[index].effect(this,laCible)

    }

}