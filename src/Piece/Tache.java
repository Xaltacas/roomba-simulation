package Piece;
import Geometrie.Forme;
import Geometrie.Cercle;
import java.awt.*;
import javax.swing.*;
import Piece.Element;

/**
 * 
 * Classe Tache: dérive de la classe Element 
 * crée un élément à partir d'une forme et d'une couleur
 * le paramètre isSolid de l'élément est mis à false dans le constructeur
 *
 */
public class Tache extends Element {
	/**
	 * Construceur 
	 */
	/**
	 * @param nc couleur à donner à la tache
	 * @param nforme forme à donner à la tache 
	 */
	public Tache(Color nc, Cercle nforme){
		super (nc,nforme);
		isSolid = false;
	}
	
	/**
	 * Méthode toString : renvoie un String contenant le type la forme et ces paramètres de l'élément
	 */
	public String toString() {
		return ("la tache est de forme " + this.forme.toString() );
	}
	
	/**
	 * Méthode simulant le nettoyage de la tache en la rendant non visible
	 */
	public void aspirer () { // passe la tache en blanc
		this.c = Color.white;
	}
	
}
