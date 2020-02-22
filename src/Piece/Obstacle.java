package Piece;
import java.awt.Color;
import Geometrie.Cercle;

import Geometrie.Forme;

public class Obstacle extends Element {

	Obstacle (Color nc, Cercle nforme){
		super (nc,nforme);
		isSolid = true;
	}
	
	public String toString() {
		return ("l'obstacle est de forme" + this.forme.toString() );
	}
	
}
