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
	 * isSolid est � true si l'�l�ment est solide et � false sinon
	 */
	protected boolean isSolid;
	
	/**
	 * Constructeur 
	 */
	/**
	 * @param nc couleur de de l'�l�ment cr��
	 * @param nforme forme de l'�l�ment cr��
	 */
	// Constructeur
	
	Element (Color nc, Forme nforme){
		this.c = nc;
		this.forme = nforme;
	}
	
	// M�thodes 
	
	/**
	 * getter
	 * @return la couleur de l'�l�ment
	 */
	public Color getColor(){
		return this.c;
	}
	
	/**
	 * getter
	 * @return la forme de l'�l�ment
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
	 * M�thode Abstraite toString
	 */
	public abstract String toString();
	
}
