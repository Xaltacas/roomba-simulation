package Piece;
import Geometrie.Forme;
import Geometrie.Cercle;
import java.awt.*;
import javax.swing.*;
import Piece.Element;

/**
 * 
 * Classe Tache: d�rive de la classe Element 
 * cr�e un �l�ment � partir d'une forme et d'une couleur
 * le param�tre isSolid de l'�l�ment est mis � false dans le constructeur
 *
 */
public class Tache extends Element {
	/**
	 * Construceur 
	 */
	/**
	 * @param nc couleur � donner � la tache
	 * @param nforme forme � donner � la tache 
	 */
	public Tache(Color nc, Cercle nforme){
		super (nc,nforme);
		isSolid = false;
	}
	
	/**
	 * M�thode toString : renvoie un String contenant le type la forme et ces param�tres de l'�l�ment
	 */
	public String toString() {
		return ("la tache est de forme " + this.forme.toString() );
	}
	
	/**
	 * M�thode simulant le nettoyage de la tache en la rendant non visible
	 */
	public void aspirer () { // passe la tache en blanc
		this.c = Color.white;
	}
	
}
