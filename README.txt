Projet de POO - Simulateur de robot mobile

Marjorie Paillet
Adrien Piednoel

Objectif du programme : simuler un robot mobile aspirateur type robot roomba

Lancement du programme : le main du programme se trouve dans la classe Simulation du package Simulateur.

Arret du programme : la croix de la fenÃªtre de la simulation permet la fermeture de la fenetre et l'arrÃªt du programme

Principe gÃ©nÃ©ral : le programmeur organise son environnement comme il le souhaite en y plaÃ§ant des obstacles et des taches. Le robot se dÃ©place alÃ©atoirement.
			En cas de dÃ©tection d'une collision la couleur de la tache est modifiÃ©e pour se fondre dans le fond et disparaitre. Le robot s'arrete
			lorsqu'il n'y a plus de tache.

Organisation du programme:5 package
	- GeomÃ©trie : est composÃ© de quatres classes (hors Junit test)
			La classe forme est une classe abstraite definisant les caractéristique communes des formes dans ce simulateurs : chaque forme doit pouvoir dire si
			il y a intersection avec une autre fome.
			Les formes implémentées sont Arc, Cercle et Rectangle.
			Les différents types de collisions ont été implémentés si ils sont pertinents dans le cadre du projet (collision rectangle /rectangle non implémentées 
			par exemple car inutiles dans cette simulation). Chaque collision implémentée est sujette des tests unitaires. Malgré ces tests pourtant validé il persiste
			une erreur de logique dans les collisions avec les Arcs visible lors de la simulation que je n'ai pas été en mesure de débuguer.
			
	- Hardware : est composÃ© de quatres classes (hors Junit test)
			La classe robot représente le roomba dans cette simulation et realise le lien entre sa posture (position) son comportement et ses capteurs
			La classe Capteur est une classe abstraite definisant les caractéristique communes des capteurs dans ce simulateurs : ils doivent pouvoir mettre à jour
			leur position à partir de la position du robot auquel le capteur est attaché.
			Les capteurs implémentés sont les capteurs de collision et les capteur de saleté.
			
	- Logique : est composÃ© de trois classes
			Posture est la classe représentant la position du robot et implémentant les méthodes relatives au mouvment du robot.
			La classe Comportement est une classe abstraite definisant les caractéristique communes des Comportement dans ce simulateurs : ils doivement posseder
			une methode move qui permet de deplacer le robot en argument suivant la logique du comportement
			Seule la classe ComportementAléatoire est implémentée.
			
	- Piece : est composÃ© de quatres classes (hors Junit test)
			La classe Element est une classe abstaite dÃ©finissant les caractÃ©ristiques communes d'un Ã©lÃ©ment de la simulation. 
			Elle est la classe parente de Tache et Obscacle. Cette organisation ce justifie par le fait qu'elle permet
			de pouvoir crÃ©er d'autres classes dÃ©finissant de nouveaux types d'Ã©lÃ©ments qui pourront etre traitÃ©s sans avoir 
			Ã  reprendre le reste du code. Cette manipulation est permise par l'utilisation dans le traitement du code d'une liste 
			de type Element.
			Ce package contient aussi la classe concrÃ¨te Environnement qui dÃ©crit l'environnement de la simulation : sa taille (400*400)
			le robot de la simulation et les Elements qu'elle contiendra.

	- Simulateur : est composÃ© de deux classes concrÃ¨tes: IHMRooma qui Extend de JPanel prend en charge l'affichage de la simulation
			et Simulation commande la simulation. le nombre d'Ã©lÃ©ments et leur dispositon est dÃ©fini dans Simulation Ã  l'initailisation
			(avant la boucle while(true)). C'est le programmeur qui dispose les Ã©lÃ©ments de sont environnement comme il le souhaite.
			La classe simulateur gÃ¨re l'affichage et le contrÃ´le d'un bouton start (permettant le lancement de la simulation) et d'un bouton pause
			(permettant l'arret et la reprise de la simulation).


Certaines classe concrètes ne font pas l'objet de tests unitaires lorsque il ne parraissaient pas pertinent :
Le comportement aléatoire n'est pas testé car sa sortie est aléatoire.
Les capteurs testent simplement des collisions entre deux formes, leurs tests sont donc équivalents à tester les intersections entre les formes.

La javadoc n'a pas été générée mais le code est commandé au format javadoc.

Les problèmes dans la logique des intersections avec les arcs font que le robot se coince parfois dans les obstacles. L'apparence "aléatoire" de ce problème de collision
l'a rendu très dur a diagnostiquer et je n'ai pas réussis à le debuguer.
