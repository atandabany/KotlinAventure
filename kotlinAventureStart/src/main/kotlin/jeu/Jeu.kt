package jeu

import personnage.Personnage



import cotteMailleAdamantine
import dague
import hache
import item.Arme
import item.Item
import personnage.Guerrier
import personnage.Mage
import personnage.Voleur
import potionDeSoins
import qualiteEpic
import qualiteLegendaire


class Jeu(monstres: List<Personnage>) {
    lateinit var joueur: Personnage

    var combats: MutableList<Combat> = mutableListOf()
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }



    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("*** Création de votre personnage ***")
        // TODO Mission 1.1
        println("Saisir le nom :")
        val nomPerso= readln();
        val attaquePerso = 12
        val defensePerso = 8
        val enduPerso = 8
        val vitessePerso = 10
        val ptsVieBase = 50
        val ptsVieMax = 50
        var ptsAttaque = 0
        var ptsDefense = 0
        var ptsEndurance = 0
        var ptsVitesse = 0
        var ptsVieF = 0
        val hache2 = Arme("Hache + 2", "Une hache tranchante", hache, qualiteEpic)
        val edict = Arme("Edict", "Une dague légendaire en mithril", dague, qualiteLegendaire)
        var inventaire: MutableList<Item> = mutableListOf(edict,cotteMailleAdamantine,hache2,potionDeSoins)
        val armure= cotteMailleAdamantine

        println("Saisir les points de spécialité. 40 point au maximum")
        do {
            println("Point d'attaque : ")
            ptsAttaque = readln().toInt();

            println("Point défense : ")
            ptsDefense = readln().toInt();

            println("Point d'endurance : ")
            ptsEndurance = readln().toInt();

            println("Point de vitesse : ")
            ptsVitesse = readln().toInt();

            val caracteristique: Int = ptsAttaque + ptsDefense + ptsEndurance + ptsVitesse
        }while (caracteristique < 40 || caracteristique > 40)

        /**
         * Statistique de base + Point de spécialité
         */
        val totalAttaque = attaquePerso + ptsAttaque
        val totalDefense = defensePerso + ptsDefense
        val totalEnduPerso = enduPerso + ptsEndurance
        val totalVitesse = vitessePerso + ptsVitesse

        /**
         * Calcule des points de vie en fonction de l'endurance
         */
        if (ptsEndurance > 1 ) {
            ptsVieF = ptsEndurance * 10
        }
        val ptsVieMin = ptsVieF + ptsVieBase
        val ptsVieFinalMax = ptsVieF + ptsVieMax

        println("Choisir une classe : 0 -> Guerrier ; 1 -> Mage ; 2 -> Voleur")
        val classe = readln().toString()
        var hero = Personnage(nomPerso,ptsVieMin,ptsVieFinalMax,totalAttaque,totalDefense,totalEnduPerso,totalVitesse,inventaire,edict,armure)
        when(classe){
            "0" -> {hero =Guerrier(nomPerso,ptsVieMin,ptsVieFinalMax,totalAttaque,totalDefense,totalEnduPerso,totalVitesse,inventaire,edict,armure)
                println("Vous êtes un Guerrier !")
            }
            "1" -> {hero = Mage(nomPerso,ptsVieMin,ptsVieFinalMax,totalAttaque,totalDefense,totalEnduPerso,totalVitesse,inventaire,edict,armure,
                mutableListOf())
                println("Vous êtes un Mage !")
            }
            "2" -> {hero =Voleur(nomPerso,ptsVieMin,ptsVieFinalMax,totalAttaque,totalDefense,totalEnduPerso,totalVitesse,inventaire,edict,armure)
                println("Vous êtes un Voleur !")
            }

        }
        //println("You are ${hero.javaClass.simpleName}")
        this.joueur = hero
        return hero
    }
}