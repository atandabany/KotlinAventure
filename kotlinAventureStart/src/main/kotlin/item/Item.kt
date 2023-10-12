package item

import jdk.jfr.Description
import personnage.Personnage

abstract class Item(val nom: String, val description: String) {

    /**
     * @author Adrien
     * @param Personnage
     * Méthode pour faire hériter la méthode 'utiliser' de la classe mère aux classes filles.
     */
    open fun utiliser(cible: Personnage) {
        println("$nom ne peut pas etre utilisé")
    }
    /**
     * @author
     * @param
     * @return
     * Méthode pour ...
     */
    override fun toString(): String {
        return "${nom} (nom='$nom' , description ='$description')"
    }
}