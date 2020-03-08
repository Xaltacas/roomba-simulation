package Piece;
import java.awt.Color;
import Geometrie.Cercle;

import Geometrie.Forme;

/**
 * 
 * Classe Obstacle: dérive de la classe Element 
 * crée un élément à partir d'une forme et d'une couleur
 * le paramètre isSolid de l'élément est mis à true dans le constructeur
 *
 */
public class Obstacle extends Element {
	
	/**
	 * Construceur 
	 */
	/**
	 * @param nc couleur à donner à la tache
	 * @param nforme forme à donner à la tache 
	 */
	public Obstacle (Color nc, Forme nforme){
		super (nc,nforme);
		isSolid = true;
	}
	
	/**
	 * Méthode toString : renvoie un String contenant le type et la forme et ces paramètres de l'élément
	 */
	public String toString() {
		return ("l'obstacle est de forme " + this.forme.toString() );
	}
	
}
