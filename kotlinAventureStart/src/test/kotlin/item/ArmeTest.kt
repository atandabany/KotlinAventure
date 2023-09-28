package item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import typeHache
import qualiteRare

class ArmeTest {

    @Test
    fun calculerDegat(){
        val uneHache=Arme("hache +1","",typeHache,qualiteRare)
        var result=uneHache.calculerDegats()
        Assertions.assertTrue(result>=2)
        Assertions.assertTrue(result<=17)

    }
}