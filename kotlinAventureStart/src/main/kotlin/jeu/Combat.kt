package jeu

import item.Arme
import item.Armure
import item.Bombe
import item.Potion
import personnage.Mage
import personnage.Personnage
import personnage.Voleur

class Combat(
    val jeu: Jeu,
    val monstre: Personnage,

    ) {
    var nombreTours: Int = 1


    /**
     * @author Adrien
     * Méthode pour simuler un tour de combat
     * Le joueur à la possiblité de chosir une action : passer son tour, boire une potion etc...
     * Chaque action permet d'appeler des méthodes.
     * Exemple : l'action 'Aller dans son inventaire', appelera les méthodes 'afficheInventaire' et 'utiliser'
     */
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
        //TODO Mission 1.2
        println("Choisir une action : 0 => Attaquer ; 1 => Passer son tour ; 2 => Boire une potion ; 3 => Inventaire ; 4 => Lancer un sort ; 5 => Voler un item")
        val action = readln()

        // Permet de choisir une action en fonction du chiffre indiqué
        when (action) {
            "0" -> this.jeu.joueur.attaque(monstre)
            "1" -> println("${this.jeu.joueur.nom} passe son tour...")
            "2" -> this.jeu.joueur.boirePotion()
            "3" -> {
                val posObjet = this.jeu.joueur.afficheInventaire()
                val objet = this.jeu.joueur.inventaire[posObjet]

                if (objet is Bombe) {
                    objet.utiliser(monstre)
                } else {
                    objet.utiliser(this.jeu.joueur)
                }
            }

            "4" -> {
                val leMage = this.jeu.joueur as Mage
                leMage.choisirEtLancerSort(monstre)
            }

            "5" -> {
                val leVoleur = this.jeu.joueur as Voleur
                leVoleur.volerItem(monstre)
            }
        }


        println("\u001b[0m")
    }

    /**
     * @author Devamadushan
     * Méthode pour simuler le tour de combat du monstre, avec l'option aléatoire "passer son tour ou attaquer"
     */
    fun tourDeMonstre() {
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
        var potionMonstre = monstre.avoirPotion()
        var pv = monstre.pointDeVie < monstre.pointDeVieMax / 2

        //TODO Mission 1.3 VALIDÉ
        val attaque = (1..100).random()
        if (attaque <= 70) {
            this.monstre.attaque(this.jeu.joueur)
        } else if (potionMonstre && pv && attaque <= 80) {
            monstre.boirePotion()

        } else {
            println("${monstre.nom} passe son tour... ")
        }
        println("\u001b[0m")
    }


    /**
     * @author  M. Moulin
     * Méthode pour exécuter le combat entre le joueur et le monstre.
     * Affiche les PV et les actions qui ont été choisies par le joueur et le monstre (pour chaque tour)
     */
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse // La vitesse indique qui commence
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) { // Tant que le joueur et le monstre sont vivants
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}