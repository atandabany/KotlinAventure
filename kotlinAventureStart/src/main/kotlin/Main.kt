import item.Qualite
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")




fun main(args: Array<String>) {
    //Instantiation des monstres
    val gobelin = Personnage(
        "XXX le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6)


    // TODO Intermission 1 Ajouter d'autres monstres
    val Black = Personnage(
        "Black",
        pointDeVie = 900000,
        pointDeVieMax = 20,
        attaque = 50,
        defense = 4,
        vitesse = 11,
        endurance = 6)

    val Dragon = Personnage(
        "Steeven le dragon",
        pointDeVie = 350,
        pointDeVieMax = 350,
        attaque = 100,
        defense = 150,
        vitesse = 200,
        endurance = 50)

    val Elfe = Personnage(
        "Elfe Noir",
        pointDeVie = 0,
        pointDeVieMax = 250,
        attaque = 150,
        defense = 100,
        vitesse = 150,
        endurance = 80)

    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin))
    //Lancement du jeu
    jeu.lancerCombat()



}
