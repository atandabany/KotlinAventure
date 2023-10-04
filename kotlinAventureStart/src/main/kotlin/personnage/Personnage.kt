package personnage

import item.*
import item.Armure

class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var inventaire: MutableList<Item> = mutableListOf(),
    var armePrincipale:Arme?,
    var armure: Armure?

) {

    // Méthode pour attaquer un adversaire
    fun attaque(adversaire: Personnage) {
        /**
         * Degats de base du personnage / 2
         */
        var degats = this.attaque / 2
        /**
         * Vérifie si le personnage possède une arme, si il possède une arme
         * calcule les degats en fontion des dégats de l'arme
         */
        if (armePrincipale != null) {
            degats += this.armePrincipale!!.calculerDegats()
        }
        /**
         * Ajuste les degats de l'adversaire en fonction de sa défense
         * (note) si les dégats > a la défense de l'adversaire affiche minimum 1
         */
        degats -= adversaire.calculeDefense()
        if (degats <= 1) {
            degats = 1
        }
        /**
         * Degats sur l'adversaire dépend de ses points de vie
         */
        adversaire.pointDeVie -= degats
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
    }

    /**
     * Creation de la methode "equipe" afin d'équiper une arme
     */
    fun equipe(uneArme: Arme) {
        if (uneArme in inventaire) {
            armePrincipale = uneArme
            println("$nom equipe ${uneArme.nom}")
        }

    }


    // TODO Mission 5.2
    /**
     * Méthode qui permet d'additionner les caractéristiques de l'armure à la défense total du personnage
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
     * Création de la méthode "equipe" pour équiper une armure
     */
    fun equipe(uneAmure: Armure) {
        if (uneAmure in inventaire) {
            this.armure = uneAmure
            println("${this.nom} equipe ${uneAmure.nom}")
        }
    }


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

    fun avoirBombe(): Boolean {
        var result: Boolean = false
        for (item in inventaire) {
            if (item is Bombe) {
                result = true
            }
        }
        return result
    }

    fun boirePotion() {

        var soins: Int = 0
        var nomSoins: String? = null//="BLA"
        var pointDeVieMax = this.pointDeVieMax

        for (item in inventaire) {
            if (item is Potion) {
                soins = item.soins
                nomSoins = item.nom
                inventaire.remove(item)
                break
            }

        }

        if (this.pointDeVie + soins >= pointDeVieMax) {
            soins = this.pointDeVieMax - this.pointDeVie
            this.pointDeVie = this.pointDeVieMax
        } else {
            this.pointDeVie += soins
        }

        println("$nomSoins a augmenté de $soins PV")


    }

    fun afficheInventaire(monstre : Personnage) {
        /**
         * Affiche chaque item de l'inventaire et parcourir l'inventaire
         */
        println("Inventaire $nom")
        val size = inventaire.size

        /**
         * Associé chaque numero des items à l'inventaire
         */
        for (i in 0..size) {
            val item = inventaire[i]
            println("$i => ${item.nom}")

        }
        


    }
        /**
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