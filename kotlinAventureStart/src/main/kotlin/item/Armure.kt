package item

import personnage.Personnage

class Armure (
    val nom:String,
    val description:String,
    val qualite: Qualite,
    val typeArmure: TypeArmure) {


    fun calculProtection():Int{
        var additionProtection = this.typeArmure.bonusType + this.qualite.bonusRarete
        return additionProtection
    }

    fun utiliser(personnage: Personnage) {
    }
}