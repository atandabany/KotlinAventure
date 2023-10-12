package personnage

import item.*
import item.Armure

open class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var inventaire: MutableList<Item> = mutableListOf(),
    var armePrincipale: Arme?,
    var armure: Armure?

) {

    /**
     * @author Steeven
     * @param adversaire
     * Méthode pour attaquer un adversaire
     * if armePrincipale vérifie si le joueur possède une arme ou non si c'est le cas calcule les degats
     * A savoir : degat est toujours = 1
     */

    open fun attaque(adversaire: Personnage) {
        var degats = this.attaque / 2
        if (armePrincipale != null) {
            degats += this.armePrincipale!!.calculerDegats()
        }
        degats -= adversaire.calculeDefense()
        if (degats <= 1) {
            degats = 1
        }
        adversaire.pointDeVie -= degats
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
    }

    /**
     * @author Steeven
     * @param uneArme
     * Creation de la methode "equipe" afin d'équiper une arme
     * if vérifie si dans l'inventaire il existe une arme
     */
    open fun equipe(uneArme: Arme) {
        if (uneArme in inventaire) {
            armePrincipale = uneArme
            println("$nom équipe « ${uneArme.nom} ».")
        }

    }


    // TODO Mission 5.2
    /**
     * @author Adrien
     * Méthode qui permet d'additionner les caractéristiques de l'armure à la défense total du personnage
     * @return result
     */
    fun calculeDefense(): Int {
        var result = this.defense / 2
        //TODO Mission 5.2
        if (this.armure != null) {
            result = result + this.armure!!.calculProtection()
        }
        return result;
    }


    /**
     * @author Adrien
     * @param uneAmure
     * Création de la méthode "equipe" pour équiper une armure
     */
    fun equipe(uneAmure: Armure) {
        if (uneAmure in inventaire) {
            this.armure = uneAmure
            println("${this.nom} equipe ${uneAmure.nom}")
        }
    }


    /**
     * @author Devamadushan
     * Création de la méthode "avoirPotion" permet de savoir si on a une potion dans l'inventaire
     * @return result
     */
    //TODO Mission 5.3
    fun avoirPotion(): Boolean {
        var result: Boolean = false
        for (item in inventaire) {
            if (item is Potion) {
                result = true
            }
        }
        return result
    }

    /**
     * @author Devamadushan
     * Création de la méthode "avoirBombe" permet de savoir si on a une Bombe dans l'inventaire
     * @return result
     */

    fun avoirBombe(): Boolean {

        var result: Boolean = false

        for (item in inventaire) {
            if (item is Bombe) {
                result = true
            }
        }
        return result
    }

    /**
     * @author Devamadushan
     * Création de la méthode "boirePotion" pour boire la  potion
     * @param unePotion  (facultatif) la potioon que l'on souhaite boire
     */
    fun boirePotion(unePotion: Potion? = null) {

        var soins: Int = 0
        var nomSoins: String? = null//="BLA"
        var pointDeVieMax = this.pointDeVieMax

        if (unePotion == null) {
            for (item in inventaire) {
                if (item is Potion) {
                    soins = item.soins
                    nomSoins = item.nom
                    inventaire.remove(item)
                    break
                }

            }
        } else {
            soins = unePotion.soins
            nomSoins = unePotion.nom
            inventaire.remove(unePotion)
        }


        if (this.pointDeVie + soins >= pointDeVieMax) {
            soins = this.pointDeVieMax - this.pointDeVie
            this.pointDeVie = this.pointDeVieMax
        } else {
            this.pointDeVie += soins
        }

        println("$nomSoins a augmenté de $soins PV")


    }

    /**
     * @author Steeven
     * Création de la méthode afficheInventaire pour afficher chaque item de l'inventaire
     * .size parcours l'inventaire
     * for permet d'associé chaque numero a chaque item de l'inventaire
     * @return option
     */
    fun afficheInventaire(): Int {
        println("Inventaire $nom")
        val size = inventaire.size

        for (i in 0..size - 1) {
            val item = inventaire[i]
            println("$i => ${item.nom}")

        }

        println("choisir un item : ")
        var option: Int

        do {
            option = readln().toInt()
//            option in (0..inventaire.size-1)
        } while (option <= inventaire.size - 1 && option >= 0)
        return option


    }

    /**
     * @author Steeven
     * Methode qui vérifie si les pvs sont inférieur ou égale a 0 si c'est le
     * cas remplace arme et armure par l'objet courant
     */
    fun loot(cible: Personnage) {
        if (cible.pointDeVie <= 0) {
            armePrincipale = null
            armure = null
            println("${this.nom} loot ${cible.nom}")
            println("${cible.inventaire}")
            this.inventaire.addAll(cible.inventaire)


        }
    }


    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }

}