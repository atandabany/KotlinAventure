package item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import personnage.Personnage

class BombeTest {

    @Test
    fun testutiliser() {
    repeat(100){


        val monstre = Personnage("black",71,71,10,20,20,10)
        val bombe = Bombe(2,8,"grenade","met des dégats grave")

        bombe.utiliser(monstre)
        val degeatInfliger = 71-monstre.pointDeVie

        //verification de l'objet
        Assertions.assertTrue(degeatInfliger>=1)
        Assertions.assertTrue(degeatInfliger<=16+monstre.calculeDefense())
    }
  }




}