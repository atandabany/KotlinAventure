package personnage

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import sortBouleDeFeu
import invocationArmeMagique
import missileMagique
import sortDeSoins

class SortTest {
    val monstre = Personnage("black", 71, 71, 10, 20, 20, 10, mutableListOf(), null, null)
    val mage = Mage("Deva", 4, 10, 10, 10, 8, 10, mutableListOf(), null, null)

    @Test
    fun sortBouleDeFeuTest() {
        sortBouleDeFeu.effect(mage, monstre)
    }

    @Test
    fun missileMagiqueTest() {
        missileMagique.effect(mage, monstre)
    }

    @Test
    fun invocationArmeMagiqueTest() {
        invocationArmeMagique.effect(mage, monstre)
    }

    @Test
    fun sortDeSoinsTest() {
        sortDeSoins.effect(mage, monstre)
    }
}
