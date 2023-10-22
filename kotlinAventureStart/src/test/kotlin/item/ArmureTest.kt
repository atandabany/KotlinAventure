package item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import qualiteCommun
import typeArmure1

class ArmureTest {
    @Test
    fun calculProtection() {
        //creation d'un objet armure de type Armure
        val armure = Armure("", "", qualiteCommun, typeArmure1)
        val result = armure.calculProtection()
        Assertions.assertEquals(1, result)
    }
}