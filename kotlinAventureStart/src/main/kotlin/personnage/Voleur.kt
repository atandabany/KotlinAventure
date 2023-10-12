package personnage

import item.*

/**
 * @author Adrien
 * Class Voleur issu de l'héritage Personnage
 */

class Voleur(
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    inventaire: MutableList<Item> = mutableListOf(),
    armePrincipale: Arme?,
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
    /**
     * @author Adrien
     * @param cible
     * Méthode volerItem permet de vérifier si l'adversaire a un item dans son inventaire
     * si c'est le cas un objet est choisi aléatoirement dans l'inventaire de la cible
     * l'objet sera supprimé dans son inventaire et de son armePrincipale et sera attribué
     * dans l'inventaire du joueur
     */
    fun volerItem(cible: Personnage) {
        if (cible.inventaire.isNotEmpty()) {
            var positionObjet = (1..cible.inventaire.size).random()
            var objet = cible.inventaire[positionObjet]

            if (objet == cible.armePrincipale) {
                cible.inventaire.remove(objet)
                cible.armePrincipale = null
                this.inventaire.add(cible.inventaire[positionObjet])
            }
            if (objet == cible.armure) {
                cible.inventaire.remove(objet)
                cible.armure = null
                this.inventaire.add(cible.inventaire[positionObjet])
            }
            if (objet is Bombe) {
                cible.inventaire.remove(objet)
                this.inventaire.add(cible.inventaire[positionObjet])
            }
            if (objet is Potion) {
                cible.inventaire.remove(objet)
                this.inventaire.add(cible.inventaire[positionObjet])
            }
            println("L'objet ${objet.nom} a été volé et a été ajouté dans l'inventaire")
        } else
            println("L'inventaire de la cible est vide")

        /**
         * Méthode proposer par M. Moulin
         */
////                this.inventaire.add(objet)
////                cible.inventaire.remove(objet)
////
////                if (objet==cible.armePrincipale ) {
////                    cible.armePrincipale = null
////                }
////                if (objet==cible.armure) {
////                    cible.armure=null
//                }
////                    this.inventaire.add(cible.inventaire[positionObjet]
//                }
    }
}

