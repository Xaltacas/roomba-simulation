Objectif du programme : simuler un robot mobile aspirateur type robot roomba ayant un comportement aléatoire 

Lancement du programme : le main du programme se trouve dans la classe Simulation du package Simulateur. Pour lacer la simulation il faut appuyer sur le bouton Start 
				affiché en haut de la fenêtre

Arret du programme : la croix de la fenêtre de la simulation permet la fermeture de la fenetre et l'arrêt du programme

Principe général : le programmeur organise son environnement comme il le souhaite en y plaçant des obstacles et des taches. le robot se déplace aléatoirement.
			En cas de détection d'une collision la couleur de la tache est modifiée pour se fondre dans le fond et disparaitre. Le robot s'arrete
			lorsqu'il n'y a plus de tache.

Organisation du programme:5 package
	- Geométrie 
	- Hardware
	- Logique
	- Piece : est composé de quatres classes (hors Junit test)
			La classe Element est une classe abstaite définissant les caractéristiques communes d'un élément de la simulation. 
			Elle est la classe parente de Tache et Obscacle. Cette organisation ce justifie par le fait qu'elle permet
			de pouvoir créer d'autres classes définissant de nouveaux types d'éléments qui pourront etre traités sans avoir 
			à reprendre le reste du code. Cette manipulation est permise par l'utilisation dans le traitement du code d'une liste 
			de type Element.
			Ce package contient aussi la classe concrète Environnement qui décrit l'environnement de la simulation : sa taille (400*400)
			le robot de la simulation et les Elements qu'elle contiendra.

	- Simulateur : est composé de deux classes concrètes: IHMRooma qui Extend de JPanel prend en charge l'affichage de la simulation
			et Simulation commande la simulation. le nombre d'éléments et leur dispositon est défini dans Simulation à l'initailisation
			(avant la boucle while(true)). C'est le programmeur qui dispose les éléments de sont environnement comme il le souhaite.
			La classe simulateur gère l'affichage et le contrôle d'un bouton start (permettant le lancement de la simulation) et d'un bouton pause
			(permettant l'arret et la reprise de la simulation).


