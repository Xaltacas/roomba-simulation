package Piece;
import Geometrie.Forme;
import java.awt.*;
import javax.swing.*;


public abstract class Element {

	//attributs
	
	private Color c;
	private Forme forme;
	private boolean isSolid;
	
	// Constructeur
	
	Element (Color nc, Forme nforme){
		this.c = nc;
		this.forme = nforme;
	}
	
	public abstract String toString();
	public abstract void draw(Graphics2D g);
	
}
