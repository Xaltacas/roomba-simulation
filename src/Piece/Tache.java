package Piece;
import Geometrie.Forme;
import java.awt.*;
import javax.swing.*;
import Piece.Element;

public class Tache extends Element {

	Tache(Color nc, Forme nforme){
		super (nc,nforme);
	}
	
	public String toString() {
		return ("la tache est de forme" + this.forme.toString() );
	}
	
	public void draw(Graphics2D g) {
		
	}
	
	public void aspirer () { // passe la tache en blanc
		this.c = Color.white;
	}
	
}