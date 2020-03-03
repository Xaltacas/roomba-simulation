package Simulateur;

import Logique.Comportement;
import Piece.Environement;
import java.util.Random;

public class Robot2 {
	private int diametre;
	private int posX;
	private int posY;
	private Environement env;
	
	public Robot2(int ndiametre, int nposX, int nposY, Environement nenv) {
		this.diametre = ndiametre;
		this.env = nenv;
		this.posX=nposX;
		this.posY=nposY;
	
	}

    public int getPosX() {return posX;}
	
	public int getPosY() {return posY;}
	
	public void updatePos () {
		Random signe = new Random();
		if (signe.nextInt(2)==1) {
			posX = posX + 1;
		}else {
			posX = posX - 1;
		}
		if (signe.nextInt(2)==1) {
			posY = posY + 1;
		}else {
			posY = posY - 1;
		}
	}
	
}