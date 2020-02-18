package Piece;
import Geometrie.Forme;
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
	
	public abstract String toString();
	
}
