package personnage

import item.Arme
import item.Armure
import item.Item

/**
 * @author Steeven
 * @param
 * Class Guerrier avec ses attributs issu de l'héritage Personnage
 */

class Guerrier(
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    inventaire: MutableList<Item> = mutableListOf(),
    armePrincipale: Arme?,
    var armeSecondaire: Arme?,
    armure: Armure?
) : Personnage(
    nom,
    pointDeVie,
    pointDeVieMax,
    attaque,
    defense,
    endurance,
    vitesse,
    inventaire,
    armePrincipale,
    armure
) {

    fun afficheArmes() {
    }

    /**
     * @author Steeven
     * Méthode pour choisir l'emplacement de l'arme SI le joueur choisi la classe Guerrier
     * Appel la méthode equipe pour équiper l'arme dans un des emplacements séléctionner
     * if vérifie si une arme est stocké dans l'inventaire
     */
    override fun equipe(uneArme: Arme) {
        println("Choisir l'emplacement de l'arme : 0 -> armePrincipale ; 1 -> armeSecondaire")
        val emplacementArme = readln().toString()

        when (emplacementArme) {
            "0" -> {
                super.equipe(uneArme)
                println("L'arme est en arme principale")
            }
            "1" -> {
                if (uneArme in inventaire) {
                    armeSecondaire = uneArme
                    println("L'arme est en arme secondaire")
                }
            }
        }
    }

    /**
     * @author Steeven
     * Méthode attaque qui permet d'attaquer avec l'arme secondaire
     * Utilisation de la méthode attaque pour attaquer
     * if vérifie si le joueur possède une arme seconde ou non
     */
    override fun attaque(adversaire: Personnage) {

        var degats = this.attaque / 2

        super.attaque(adversaire)

        if (armeSecondaire != null) {
            degats += this.armeSecondaire!!.calculerDegats()
        }
        degats = degats - adversaire.calculeDefense()

        if (degats <= 1) {
            degats = 1
        }
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")

    }
}