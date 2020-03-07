package Piece;
import java.awt.Color;
import java.util.ArrayList;
import Simulateur.Robot2;
import Piece.Element;
import Hardware.Robot;

public class Environement {
 
	// attributs 
	private Robot rob;
	private ArrayList<Element> elems;
	private int sizeX;
	private int sizeY;
	private int nbTaches;
	
	// constructeur 
	
	 public Environement(int nsizeX, int nsizeY){
		this.sizeX=nsizeX;
		this.sizeY=nsizeY;
		this.elems = new ArrayList<Element>();
	}
	
	//méthodes 
	public void addRobot(Robot r){
		this.rob = r;
	}
	
	public void addElem(Element e){
		this.elems.add(e);
		System.out.println("element ajouté!");
	}
	
	public int getSizeX() {
		return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}
	
	public Robot getRobot() {
		return this.rob;
	}
	
	public ArrayList<Element> getElems(){
		return elems;
	}
	
	public void removeElem(Element e) {
		if (elems.remove(e) == false) {
			System.out.println("l'élément à supprimer n'existe pas dans la liste");
		}
	}
	public int getNbTaches () {
		int res = 0;
		for (int i =0; i<this.elems.size(); i++) {
			System.out.println("ici");
			if (this.elems.get(i).getIsSolid()== false && this.elems.get(i).getColor()!=Color.white) {
				res++;
				System.out.println("la");
			}
		}
		return res;
	}
	
	public String toString() {
		return ("l'environement a une taille de" + this.sizeX + "sur" + this.sizeY + "et contient" + this.elems.size()+"elements");
	}
}

