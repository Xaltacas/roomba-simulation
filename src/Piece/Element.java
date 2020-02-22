package Piece;
import Geometrie.Forme;
import Geometrie.Cercle;
import java.awt.*;
import javax.swing.*;


public abstract class Element {

	//attributs
	
	protected Color c;
	protected Forme forme;
	protected boolean isSolid;
	
	// Constructeur
	
	Element (Color nc, Cercle nforme){
		this.c = nc;
		this.forme = nforme;
	}
	public Color getColor(){
		return this.c;
	}
	
	public Forme getForme(){
		return this.forme;
	}
	
	public abstract String toString();
	
}
