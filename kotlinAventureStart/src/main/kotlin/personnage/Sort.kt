package personnage

/**
 * @author Devamadushan
 * Class sort relié a la classe Personnage
 */

class Sort(
    val nom: String,
    val effect: (Personnage, Personnage) -> Unit,

    ) {

}