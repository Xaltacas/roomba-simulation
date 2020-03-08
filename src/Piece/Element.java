package Piece;
import Geometrie.Forme;
import Geometrie.Cercle;
import java.awt.*;
import javax.swing.*;


public abstract class Element {

	//attributs
	/**
	 * attributs
	 */
	protected Color c;
	protected Forme forme;
	/**
	 * isSolid est à true si l'élément est solide et à false sinon
	 */
	protected boolean isSolid;
	
	/**
	 * Constructeur 
	 */
	/**
	 * @param nc couleur de de l'élément créé
	 * @param nforme forme de l'élément créé
	 */
	// Constructeur
	
	Element (Color nc, Forme nforme){
		this.c = nc;
		this.forme = nforme;
	}
	
	// Méthodes 
	
	/**
	 * getter
	 * @return la couleur de l'élément
	 */
	public Color getColor(){
		return this.c;
	}
	
	/**
	 * getter
	 * @return la forme de l'élément
	 */
	public Forme getForme(){
		return this.forme;
	}
	
	/**
	 * getter
	 * @return true si l'objet est solide false sinon
	 */
	public boolean getIsSolid() {
		return this.isSolid;
	}
	
	/**
	 * Méthode Abstraite toString
	 */
	public abstract String toString();
	
}
