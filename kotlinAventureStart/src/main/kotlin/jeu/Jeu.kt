package jeu

import personnage.Personnage



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
        println("Création votre personnage:")
        // TODO Mission 1.1
        println("Saisir le nom :")
        val nomPerso= readln();
        val attaquePerso = 12
        val defensePerso = 8
        val enduPerso = 8
        val vitessePerso = 10
        var ptsAttaque = 0
        var ptsDefense = 0
        var ptsEndurance = 0
        var ptsVitesse = 0

        println("Saisir les points de spécialité. 40 point au maximum")
        do {
            println("Point d'attaque : ")
            var ptsAttaque = readln().toInt();

            println("Point défense : ")
            var ptsDefense = readln().toInt();

            println("Point d'endurance : ")
            var ptsEndurance = readln().toInt();

            println("Point de vitesse : ")
            var ptsVitesse = readln().toInt();

            val caracteristique: Int = ptsAttaque + ptsDefense + ptsEndurance + ptsVitesse
        }while (caracteristique > 40)
        val totalAttaque = attaquePerso + ptsAttaque
        val totalDefense = defensePerso + ptsDefense
        val totalEnduPerso = enduPerso + ptsEndurance
        val totalVitesse = vitessePerso + ptsVitesse

        val hero = Personnage(nomPerso,150,150,totalAttaque,totalDefense,totalEnduPerso,totalVitesse)
        this.joueur= hero
        println(this.joueur)
        return hero
    }
    

}