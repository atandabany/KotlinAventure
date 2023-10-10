package personnage

import item.*

class Voleur (
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
):Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,inventaire,armePrincipale,armure) {

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
        }
        else
            println("L'inventaire de la cible est vide")


//
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
//            }
//        }

        }
    }

