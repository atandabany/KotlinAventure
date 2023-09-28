package item

import personnage.Personnage

class Armure (
    nom:String,
    description:String,
    val qualite: Qualite,
    val typeArmure: TypeArmure) :Item(nom, description){


    fun calculProtection():Int{
        var additionProtection = this.typeArmure.bonusType + this.qualite.bonusRarete
        return additionProtection
    }

    override fun utiliser(personnage: Personnage) {
    }
}