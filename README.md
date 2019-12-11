# java 

Repository des sources java écrit chez Simplon

# package fty.briefs

Ensemble des minis projets de la formation.

> briefs.books

- Description : https://github.com/simplonco/java-project-books/blob/master/README.md

- Utilisation :

Executer la class fty/briefs/books/Books.java

> briefs.fitness

- Description : https://simplonline.co/briefs/detail/ReGxMrNirdS74Hsd9

- Utilisation :

java fty/briefs/fitness/Fitness.class

> briefs.puissance4

- Description du jeu :
Le but du jeu est d'aligner une suite de 4 pions de même symbole (X ou O) sur une grille comptant 6 rangées et 7 colonnes. 
Chaque joueur dispose de 21 pions d'un symbole choisi (X ou O). 
Tour à tour, les deux joueurs placent un pion dans la colonne de leur choix, le pion coulisse alors jusqu'à la position la plus basse possible dans la dite colonne à la suite de quoi c'est à l'adversaire de jouer. 
Le vainqueur est le joueur qui réalise le premier un alignement (horizontal, vertical "ou diagonal") consécutif d'au moins quatre pions de son symbole. 
Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a réalisé un tel alignement, la partie est déclarée nulle. 

- Description de l'implémentation :
Matrice 6 x 7 = board [6][7] de caractères initialisés par un espace 
L'algo demande alternativement au joueur (X ou O) de choisir.
Chaque pion valide va vérifier si il est gagnant (4 pions de même symbole)

- Notice d'utilisation : 
java fty/briefs/puissance4/Puissance4.class

- Exemple d'utilisation :
run:
 1  2  3  4  5  6  7 
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
 -  -  -  -  -  -  - 
Joueur X à vous de jouer : 1
 1  2  3  4  5  6  7 
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ][ ][ ]
[X][ ][ ][ ][ ][ ][ ]
 -  -  -  -  -  -  - 
Joueur O à vous de jouer : 

# package fty.exos

Ensemble des classes des exercices issus des cours de la formation.