import item.*
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

// instanciation des types d'armures des objets
val rambourre = TypeArmure("Rambourré",1)
val cuir = TypeArmure("Cuir",2)
val cuirCloute=TypeArmure("Cuire Clouté",3)
val chemiseChaine = TypeArmure("Chemise à chaîne", 4)
val  pectoral = TypeArmure("Pectoral", 5)
val cotteDeMaille = TypeArmure("Cotte de mailles", 6)


//instanciation des bombes
val grenade = Bombe(5,6,"grenade","Une contraception qui explose une fois lancée.")
val flasquedacide= Bombe(2,8,"Flasque d'acide","Une flasque qui contient une puissante substance corrosive.")
val feuGregeois = Bombe(4,6,"Feu grégeois","Une flasque qui contient un liquide inflammable.")


// instanciation des potions
val potionDeSoins = Potion(20,"Potions de soins","Une potion qui contient un liquide rouge.")
val grandePotionDeSoins = Potion(30,"Grande potion de soins","Une grande potion qui contient un liquide rouge.")


//instanciation des armures
val cotteMailleAdamantine = Armure("Cotte de mailles en adamantine +1","Cotte de mailles plus lourde mais aussi plus solide.",qualiteRare,cotteDeMaille)
val leManteauDeLaNuit = Armure("Le manteau de la nuit","Une armure en cuir obscure comme la nuit.",qualiteEpic,cuir)
val armureDuGobelin = Armure("Armure du gobelin ","Armure en cuir rudimentaire.",qualiteCommun,cuir)

//instanciation des types d'armes des objets

/***
 * Steeven (code ici)
 */


//instanciation des Armes

/***
 * Steeven (code ici)
 */


//Exemples d'instanciation d'objet avec M. Moulin
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
        endurance = 6,
        inventaire = mutableListOf<Item>())

    // TODO Intermission 1 Ajouter d'autres monstres
    val black = Personnage(
        "Black",
        pointDeVie = 900000,
        pointDeVieMax = 20,
        attaque = 50,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        inventaire = mutableListOf<Item>())

    val dragon = Personnage(
        "Steeven le dragon",
        pointDeVie = 350,
        pointDeVieMax = 350,
        attaque = 100,
        defense = 150,
        vitesse = 200,
        endurance = 50,
        inventaire = mutableListOf<Item>())

    val elfe = Personnage(
        "Elfe Noir",
        pointDeVie = 0,
        pointDeVieMax = 250,
        attaque = 150,
        defense = 100,
        vitesse = 150,
        endurance = 80,
        inventaire = mutableListOf<Item>())

    val ameEnPeine= Personnage(
        "Ale en peine",
        pointDeVie = 67,
        pointDeVieMax = 67,
        attaque = 10,
        defense = 12,
        vitesse = 14,
        endurance = 0,
        inventaire = mutableListOf<Item>())

    val armureAnimee= Personnage(
        "Armure animée",
        pointDeVie = 33,
        pointDeVieMax = 33,
        attaque = 8,
        defense = 15,
        vitesse = 6,
        endurance = 8,
        inventaire = mutableListOf<Item>())

    val ettin= Personnage(
        "Ettin",
        pointDeVie = 88,
        pointDeVieMax = 88,
        attaque = 16,
        defense = 12,
        vitesse = 8,
        endurance = 14,
        inventaire = mutableListOf<Item>())

    val elementaireDeFeu= Personnage(
        "Élémentaire du feu",
        pointDeVie = 102,
        pointDeVieMax = 102,
        attaque = 12,
        defense = 10,
        vitesse = 16,
        endurance = 8,
        inventaire = mutableListOf<Item>())

    val flagelleurMental= Personnage(
        "Flagelleur mental",
        pointDeVie = 71,
        pointDeVieMax = 71,
        attaque = 15,
        defense = 7,
        vitesse = 12,
        endurance = 12,
        inventaire = mutableListOf<Item>())

    val geleeOcre = Personnage(
        "Gelée ocre",
        pointDeVie = 45,
        pointDeVieMax = 45,
        attaque = 9,
        defense = 14,
        vitesse = 10,
        endurance = 7,
        inventaire = mutableListOf<Item>())

    val gnoll = Personnage(
        "Gnoll",
        pointDeVie = 25,
        pointDeVieMax = 25,
        attaque = 11,
        defense = 8,
        vitesse = 14,
        endurance = 11,
        inventaire = mutableListOf<Item>())

    val gorgone = Personnage(
        "Gorgone",
        pointDeVie = 114,
        pointDeVieMax = 114,
        attaque = 18,
        defense = 14,
        vitesse = 9,
        endurance = 14,
        inventaire = mutableListOf<Item>())

    val hommeLezard = Personnage(
        "Homme-Lézard",
        pointDeVie = 22,
        pointDeVieMax = 22,
        attaque = 11,
        defense = 13,
        vitesse = 11,
        endurance = 11,
        inventaire = mutableListOf<Item>())

    val kraken = Personnage(
        "Kraken",
        pointDeVie = 472,
        pointDeVieMax = 472,
        attaque = 18,
        defense = 15,
        vitesse = 14,
        endurance = 22,
        inventaire = mutableListOf<Item>())

    val mimique = Personnage(
        "Mimique",
        pointDeVie = 58,
        pointDeVieMax = 58,
        attaque = 14,
        defense = 10,
        vitesse = 12,
        endurance = 9,
        inventaire = mutableListOf<Item>())


    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,mimique))
    //Lancement du jeu
    jeu.lancerCombat()



}
