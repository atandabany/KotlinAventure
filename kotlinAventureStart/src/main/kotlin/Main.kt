import item.Armure
import item.Qualite
import item.TypeArme
import item.TypeArmure
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

val typeHache= TypeArme(1,8,2,20)

val typeArmure1=TypeArmure("armure en cuir",1)



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
    val black = Personnage(
        "Black",
        pointDeVie = 900000,
        pointDeVieMax = 20,
        attaque = 50,
        defense = 4,
        vitesse = 11,
        endurance = 6)

    val dragon = Personnage(
        "Steeven le dragon",
        pointDeVie = 350,
        pointDeVieMax = 350,
        attaque = 100,
        defense = 150,
        vitesse = 200,
        endurance = 50)

    val elfe = Personnage(
        "Elfe Noir",
        pointDeVie = 0,
        pointDeVieMax = 250,
        attaque = 150,
        defense = 100,
        vitesse = 150,
        endurance = 80)

    val ameEnPeine= Personnage(
        "Ale en peine",
        pointDeVie = 67,
        pointDeVieMax = 67,
        attaque = 10,
        defense = 12,
        vitesse = 14,
        endurance = 0)

    val armureAnimee= Personnage(
        "Armure animée",
        pointDeVie = 33,
        pointDeVieMax = 33,
        attaque = 8,
        defense = 15,
        vitesse = 6,
        endurance = 8)

    val ettin= Personnage(
        "Ettin",
        pointDeVie = 88,
        pointDeVieMax = 88,
        attaque = 16,
        defense = 12,
        vitesse = 8,
        endurance = 14)

    val elementaireDeFeu= Personnage(
        "Élémentaire du feu",
        pointDeVie = 102,
        pointDeVieMax = 102,
        attaque = 12,
        defense = 10,
        vitesse = 16,
        endurance = 8)

    val flagelleurMental= Personnage(
        "Flagelleur mental",
        pointDeVie = 71,
        pointDeVieMax = 71,
        attaque = 15,
        defense = 7,
        vitesse = 12,
        endurance = 12)

    val geleeOcre = Personnage(
        "Gelée ocre",
        pointDeVie = 45,
        pointDeVieMax = 45,
        attaque = 9,
        defense = 14,
        vitesse = 10,
        endurance = 7)

    val gnoll = Personnage(
        "Gnoll",
        pointDeVie = 25,
        pointDeVieMax = 25,
        attaque = 11,
        defense = 8,
        vitesse = 14,
        endurance = 11)

    val gorgone = Personnage(
        "Gorgone",
        pointDeVie = 114,
        pointDeVieMax = 114,
        attaque = 18,
        defense = 14,
        vitesse = 9,
        endurance = 14)

    val hommeLezard = Personnage(
        "Homme-Lézard",
        pointDeVie = 22,
        pointDeVieMax = 22,
        attaque = 11,
        defense = 13,
        vitesse = 11,
        endurance = 11)

    val kraken = Personnage(
        "Kraken",
        pointDeVie = 472,
        pointDeVieMax = 472,
        attaque = 18,
        defense = 15,
        vitesse = 14,
        endurance = 22)

    val mimique = Personnage(
        "Mimique",
        pointDeVie = 58,
        pointDeVieMax = 58,
        attaque = 14,
        defense = 10,
        vitesse = 12,
        endurance = 9)


    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,mimique))
    //Lancement du jeu
    jeu.lancerCombat()



}
