package item


import jeu.TirageDes
import personnage.Personnage

/**
 * Création de la classe arme
 */

class Arme (val nom:String,
            val description:String,
            val type:TypeArme,
            val qualite: Qualite) {
    /**
     * Méthode pour calculer les degats de l'arme en fonction du Dès lancer
      */

    fun calculerDegats(): Int {
        var resultat = TirageDes(this.type.nombreDes, this.type.valeurDeMax).lance()
        val desCritique = TirageDes(1, 20).lance()
        if (desCritique >= this.type.activationCritique) {
            println("Coup critique")
            resultat = type.activationCritique * this.type.multiplicateurCritique

        }
        return resultat+ this.qualite.bonusRarete
    }
/**
 * Méthode pour utiliser l'arme
 */
    fun utiliser(cible: Personnage) {

    }

}