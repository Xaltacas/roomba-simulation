package Piece;
import java.awt.Color;
import Geometrie.Cercle;

import Geometrie.Forme;

/**
 * 
 * Classe Obstacle: d�rive de la classe Element 
 * cr�e un �l�ment � partir d'une forme et d'une couleur
 * le param�tre isSolid de l'�l�ment est mis � true dans le constructeur
 *
 */
public class Obstacle extends Element {
	
	/**
	 * Construceur 
	 */
	/**
	 * @param nc couleur � donner � la tache
	 * @param nforme forme � donner � la tache 
	 */
	public Obstacle (Color nc, Forme nforme){
		super (nc,nforme);
		isSolid = true;
	}
	
	/**
	 * M�thode toString : renvoie un String contenant le type et la forme et ces param�tres de l'�l�ment
	 */
	public String toString() {
		return ("l'obstacle est de forme " + this.forme.toString() );
	}
	
}
