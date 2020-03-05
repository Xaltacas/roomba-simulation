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
	
	Element (Color nc, Forme nforme){
		this.c = nc;
		this.forme = nforme;
	}
	public Color getColor(){
		return this.c;
	}
	
	public Forme getForme(){
		return this.forme;
	}
	
	public boolean getIsSolid() {
		return this.isSolid;
	}
	
	public abstract String toString();
	
}
