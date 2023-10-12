package item

import personnage.Personnage

class Potion(
    val soins: Int,
    nom: String,
    description: String
) : Item(nom, description) {

    /**
     * @author Devamadushan
     * @param cible peut etre >> un joueur ou monstre
     * Méthode 'utiliser' pour boire une potion avec l'utilisation de la méthode "boirePotion"
     */
    override fun utiliser(cible: Personnage) {
        cible.boirePotion(this)
    }
}