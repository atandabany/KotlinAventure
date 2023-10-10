
package personnage

import item.Arme
import item.Armure
import item.Item

class Guerrier (
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
    armure: Armure?):Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse,inventaire, armePrincipale, armure) {
        
    fun afficheArmes() {
    }

    /**
     * Méthode pour choisir l'emplacement de l'arme SI le joueur choisi la classe Guerrier
     */
    override fun equipe(uneArme:Arme){
        /**
         * Demande de définir l'emplacement de l'arme entre 0 et 1 (Principale et Secondaire)
         */
        println("Choisir l'emplacement de l'arme : 0 -> armePrincipale ; 1 -> armeSecondaire")
        val emplacementArme = readln().toString()

        /**
         * Appel de la méthode equipe (arme) SI on choisi l'emplacement de l'arme principale
         */
        when(emplacementArme){
            "0" -> {
                super.equipe(uneArme)
                println("L'arme est en arme principale")}

            /**
             * Vérifier que dans l'inventaire on possède bien une arme en plus
             * si c'est le cas l'arme secondaire = arme
             */
            "1" -> {
                if (uneArme in inventaire) {
                    armeSecondaire = uneArme
                    println("L'arme est en arme secondaire")
                }
            }
        }
    }

    /**
     * Méthode attaque qui permet d'attaquer avec l'arme secondaire
     */
    override fun attaque(adversaire: Personnage){

        var degats = this.attaque/2

        /**
         * Utiliser la méthode attaque car quoi qui l'arrive que ce soit avec une arme principale
         * ou secondaire, le joueur attaque
         */

        super.attaque(adversaire)

        /**
         * Condition qui vérifie que on possède une arme secondaire si c'est le cas
         * calculer les dégats de l'arme secondaire
         * sinon suivre la methode attaque
         */

        if (armeSecondaire != null){
            degats += this.armeSecondaire!!.calculerDegats()

        }

        degats = degats - adversaire.calculeDefense()


        if (degats <= 1) {
            degats = 1
        }
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")

    }
}