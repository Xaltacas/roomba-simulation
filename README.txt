Projet de POO - Simulateur de robot mobile

Marjorie Paillet
Adrien Piednoel

Objectif du programme : simuler un robot mobile aspirateur type robot roomba

Lancement du programme : le main du programme se trouve dans la classe Simulation du package Simulateur.

Arret du programme : la croix de la fenêtre de la simulation permet la fermeture de la fenetre et l'arrêt du programme

Principe général : le programmeur organise son environnement comme il le souhaite en y plaçant des obstacles et des taches. Le robot se déplace aléatoirement.
			En cas de détection d'une collision la couleur de la tache est modifiée pour se fondre dans le fond et disparaitre. Le robot s'arrete
			lorsqu'il n'y a plus de tache.

Organisation du programme:5 package
	- Geométrie : est composé de quatres classes (hors Junit test)
			La classe forme est une classe abstraite definisant les caract�ristique communes des formes dans ce simulateurs : chaque forme doit pouvoir dire si
			il y a intersection avec une autre fome.
			Les formes impl�ment�es sont Arc, Cercle et Rectangle.
			Les diff�rents types de collisions ont �t� impl�ment�s si ils sont pertinents dans le cadre du projet (collision rectangle /rectangle non impl�ment�es 
			par exemple car inutiles dans cette simulation). Chaque collision impl�ment�e est sujette des tests unitaires. Malgr� ces tests pourtant valid� il persiste
			une erreur de logique dans les collisions avec les Arcs visible lors de la simulation que je n'ai pas �t� en mesure de d�buguer.
			
	- Hardware : est composé de quatres classes (hors Junit test)
			La classe robot repr�sente le roomba dans cette simulation et realise le lien entre sa posture (position) son comportement et ses capteurs
			La classe Capteur est une classe abstraite definisant les caract�ristique communes des capteurs dans ce simulateurs : ils doivent pouvoir mettre � jour
			leur position � partir de la position du robot auquel le capteur est attach�.
			Les capteurs impl�ment�s sont les capteurs de collision et les capteur de salet�.
			
	- Logique : est composé de trois classes
			Posture est la classe repr�sentant la position du robot et impl�mentant les m�thodes relatives au mouvment du robot.
			La classe Comportement est une classe abstraite definisant les caract�ristique communes des Comportement dans ce simulateurs : ils doivement posseder
			une methode move qui permet de deplacer le robot en argument suivant la logique du comportement
			Seule la classe ComportementAl�atoire est impl�ment�e.
			
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


Certaines classe concr�tes ne font pas l'objet de tests unitaires lorsque il ne parraissaient pas pertinent :
Le comportement al�atoire n'est pas test� car sa sortie est al�atoire.
Les capteurs testent simplement des collisions entre deux formes, leurs tests sont donc �quivalents � tester les intersections entre les formes.

La javadoc n'a pas �t� g�n�r�e mais le code est command� au format javadoc.

Les probl�mes dans la logique des intersections avec les arcs font que le robot se coince parfois dans les obstacles. L'apparence "al�atoire" de ce probl�me de collision
l'a rendu tr�s dur a diagnostiquer et je n'ai pas r�ussis � le debuguer.
