import item.*
import jeu.Jeu
import jeu.TirageDes
import personnage.Personnage
import personnage.Sort

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

//initialisation des Sorts
val projectionAcide = Sort("Sort de Projection acide" , {mage, cible ->
    run {
        val tirageDes = TirageDes(1,10)
        var degat = tirageDes.lance()
        degat = maxOf(1,degat-cible.calculeDefense())
        cible.pointDeVie-=degat
        println("Le jet d'acide inflige $degat a ${cible.nom}")
    }
})

val sortDeSoins = Sort( "Sort de soins" , {caster , cible ->
    run {
        val tirageDes = TirageDes(1,6)
        var degat = tirageDes.lance()+caster.attaque/2
        caster.pointDeVie+=degat
        val pvCible = cible.pointDeVie>=cible.pointDeVieMax

        if (pvCible){
            caster.pointDeVie=cible.pointDeVieMax
        }

    }

}
)

val invocationArmeMagique = Sort("Invocation Arme Magique", {caster, cible ->
    run {
        val tirageDes = TirageDes(1,20)
        val rarete = tirageDes.lance()
        var qualite : Qualite? =null
        when {
            rarete < 5 -> qualite= qualiteCommun
            rarete < 10 -> qualite = qualiteRare
            rarete < 15 -> qualite = qualiteEpic
        else -> qualite = qualiteLegendaire
        }
        val armeMagique = Arme("Arme magique", "Blabla c'est trop bien", epeeLongue, qualite!!)
        caster.inventaire.add(armeMagique)
        caster.equipe(armeMagique)
        println("Une arme magique est ajouté à l'inventaire")
    }
})


val invocationArmureMagique = Sort("Invocation Armure Magique", {caster, cible ->
    run {
        val tirageDes = TirageDes(1,20)
        val rarete = tirageDes.lance()
        var qualite : Qualite? =null
        when {
            rarete < 5 -> qualite= qualiteCommun
            rarete < 10 -> qualite = qualiteRare
            rarete < 15 -> qualite = qualiteEpic
            else -> qualite = qualiteLegendaire
        }
        val armureMagique = Armure("Armure magique", "BlablaBla...", qualite!!, cuir)
        caster.inventaire.add(armureMagique)
        caster.equipe(armureMagique)
        println("Une armure magique est ajouté à l'inventaire")
    }
})


val bouleDeFeu = Sort("Boule de feu", {mage, cible ->
    run {
        val degatCaster = mage.attaque/3
        val tirageDes = TirageDes(1, 6)
        var degat = tirageDes.lance()
        degat += degatCaster
        degat -= cible.calculeDefense()
        cible.pointDeVie-=degat
        println("Lance une boule de feu et inflige $degat a ${cible.nom}")
    }
})

val missilemagique = Sort("Missile magique", {mage, cible ->
    run {
        var compteur = 0
        var degatCaster = mage.attaque/2
        val tirageDes = TirageDes(1, 6)
        if(compteur < degatCaster){
            var degat = tirageDes.lance()
            degat -= cible.calculeDefense()
            if (degat<=1){
                degat = 1
            }
            cible.pointDeVie-=degat
            println("Le projectile magique inflige $degat a ${cible.nom}")
            compteur+1
        }
    }
})




// instanciation des types d'armures des objets
val rambourre = TypeArmure("Rambourré",1)
val cuir = TypeArmure("Cuir",2)
val cuirCloute=TypeArmure("Cuire Clouté",3)
val chemiseChaine = TypeArmure("Chemise à chaîne", 4)
val  pectoral = TypeArmure("Pectoral", 5)
val cotteDeMaille = TypeArmure("Cotte de mailles", 6)


//instanciation des bombes
val grenade = Bombe(5,6,"grenade","Une contraception qui explose une fois lancée.")
val flasqueAcide= Bombe(2,8,"Flasque d'acide","Une flasque qui contient une puissante substance corrosive.")
val feuGregeois = Bombe(4,6,"Feu grégeois","Une flasque qui contient un liquide inflammable.")


// instanciation des potions
val potionDeSoins = Potion(20,"Potions de soins","Une potion qui contient un liquide rouge.")
val grandePotionDeSoins = Potion(30,"Grande potion de soins","Une grande potion qui contient un liquide rouge.")


//instanciation des armures
val cotteMailleAdamantine = Armure("Cotte de mailles en adamantine +1","Cotte de mailles plus lourde mais aussi plus solide.",qualiteRare,cotteDeMaille)
val leManteauDeLaNuit = Armure("Le manteau de la nuit","Une armure en cuir obscure comme la nuit.",qualiteEpic,cuir)
val armureDuGobelin = Armure("Armure du gobelin ","Armure en cuir rudimentaire.",qualiteCommun,cuir)


//instanciation des types d'armes des objets
val dague = TypeArme(1, 4, 3, 18)
val baton = TypeArme(1, 6, 2, 20)
val lance = TypeArme(1, 8, 3, 20)
val arbaleteLegere = TypeArme(1, 8, 2, 19)
val epeeCourte = TypeArme(1, 6, 2, 19)
val hache = TypeArme(1,8,3,20)
val epeeLongue = TypeArme(1 ,8, 2, 19)
val marteauGuerre = TypeArme(1, 8, 3, 20)
val arc = TypeArme(1, 8, 3, 20)





//Exemples d'instanciation d'objet avec M. Moulin
val typeHache= TypeArme(1,8,2,20)
val typeArmure1=TypeArmure("armure en cuir",1)

fun main(args: Array<String>) {
    //instanciation des Armes

    val epeeLongDroit = Arme("Epee longue du droit", "Une épée en fer froid", epeeLongue, qualiteRare)
    val lanceKobold = Arme("Lance du Kobold", "Une lance rudimentaire", lance, qualiteCommun)

    val tonnerre = Arme("Tonnerre", "Un marteau légendaire frappe comme la foudre", marteauGuerre, qualiteLegendaire)
    val arcLong= Arme("arcLong", "Un arc créer pour tuer les humains", arc, qualiteRare)

    //Instantiation des monstres

    val gobelin = Personnage(
        "XXX le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>(arcLong))
    
    // TODO Intermission 1 Ajouter d'autres monstres
    val black = Personnage(
        "Black",
        pointDeVie = 900000,
        pointDeVieMax = 20,
        attaque = 50,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        armePrincipale = lanceKobold,
        armure = armureDuGobelin,
        inventaire = mutableListOf<Item>(lanceKobold,armureDuGobelin))

    val dragon = Personnage(
        "Steeven le dragon",
        pointDeVie = 350,
        pointDeVieMax = 350,
        attaque = 100,
        defense = 150,
        vitesse = 200,
        endurance = 50,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val elfe = Personnage(
        "Elfe Noir",
        pointDeVie = 0,
        pointDeVieMax = 250,
        attaque = 150,
        defense = 100,
        vitesse = 150,
        endurance = 80,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val ameEnPeine= Personnage(
        "Ale en peine",
        pointDeVie = 67,
        pointDeVieMax = 67,
        attaque = 10,
        defense = 12,
        vitesse = 14,
        endurance = 0,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val armureAnimee= Personnage(
        "Armure animée",
        pointDeVie = 33,
        pointDeVieMax = 33,
        attaque = 8,
        defense = 15,
        vitesse = 6,
        endurance = 8,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val ettin= Personnage(
        "Ettin",
        pointDeVie = 88,
        pointDeVieMax = 88,
        attaque = 16,
        defense = 12,
        vitesse = 8,
        endurance = 14,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val elementaireDeFeu= Personnage(
        "Élémentaire du feu",
        pointDeVie = 102,
        pointDeVieMax = 102,
        attaque = 12,
        defense = 10,
        vitesse = 16,
        endurance = 8,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val flagelleurMental= Personnage(
        "Flagelleur mental",
        pointDeVie = 71,
        pointDeVieMax = 71,
        attaque = 15,
        defense = 7,
        vitesse = 12,
        endurance = 12,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val geleeOcre = Personnage(
        "Gelée ocre",
        pointDeVie = 45,
        pointDeVieMax = 45,
        attaque = 9,
        defense = 14,
        vitesse = 10,
        endurance = 7,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val gnoll = Personnage(
        "Gnoll",
        pointDeVie = 25,
        pointDeVieMax = 25,
        attaque = 11,
        defense = 8,
        vitesse = 14,
        endurance = 11,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val gorgone = Personnage(
        "Gorgone",
        pointDeVie = 114,
        pointDeVieMax = 114,
        attaque = 18,
        defense = 14,
        vitesse = 9,
        endurance = 14,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val hommeLezard = Personnage(
        "Homme-Lézard",
        pointDeVie = 22,
        pointDeVieMax = 22,
        attaque = 11,
        defense = 13,
        vitesse = 11,
        endurance = 11,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val kraken = Personnage(
        "Kraken",
        pointDeVie = 472,
        pointDeVieMax = 472,
        attaque = 18,
        defense = 15,
        vitesse = 14,
        endurance = 22,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())

    val mimique = Personnage(
        "Mimique",
        pointDeVie = 58,
        pointDeVieMax = 58,
        attaque = 14,
        defense = 10,
        vitesse = 12,
        endurance = 9,
        armePrincipale = null,
        armure = null,
        inventaire = mutableListOf<Item>())


    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,mimique))
    //Lancement du jeu
    jeu.lancerCombat()



}
