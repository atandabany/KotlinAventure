package item


import jeu.TirageDes
import personnage.Personnage

/**
 * Création de la classe Arme
 */

class Arme(
    nom: String,
    description: String,
    val type: TypeArme,
    val qualite: Qualite
) : Item(nom, description) {
    /**
     * @author Steeven
     * @param
     * @return resultat + qualite (bonus rareté)
     * Méthode pour calculer les dégats de l'arme en fonction du dès lancer.
     */
    fun calculerDegats(): Int {
        var resultat = TirageDes(this.type.nombreDes, this.type.valeurDeMax).lance()
        val desCritique = TirageDes(1, 20).lance()
        if (desCritique >= this.type.activationCritique) {
            println("Coup critique")
            resultat = type.activationCritique * this.type.multiplicateurCritique
        }
        return resultat + this.qualite.bonusRarete
    }

    /**
     * @author Adrien
     * @param Personnage
     * Méthode pour utiliser l'arme
     * Utilisation de la methode "equipe" si dans l'inventaire du personnage il possède une arme.
     */
    override fun utiliser(cible: Personnage) {
        cible.equipe(this)
    }
}