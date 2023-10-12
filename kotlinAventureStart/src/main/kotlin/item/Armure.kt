package item

import personnage.Personnage

/**
 * Création de la classe Armure
 */
class Armure(
    nom: String,
    description: String,
    val qualite: Qualite,
    val typeArmure: TypeArmure
) : Item(nom, description) {

    /**@author Adrien
     * @return type + rareté
     * Méthode "calculProtection" pour calculer la protection de l'armure
     */
    fun calculProtection(): Int {
        var additionProtection = this.typeArmure.bonusType + this.qualite.bonusRarete
        return additionProtection
    }

    /**
     * @author Adrien
     * @param Personnage
     * Méthode pour utiliser l'armurme
     * Utilisation de la methode "equipe" si dans l'inventaire du personnage il possède une armure.
     */
    override fun utiliser(joueur: Personnage) {
        joueur.equipe(this)
    }
}