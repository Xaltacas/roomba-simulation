package Piece;
import java.util.ArrayList;
import Piece.Element;
import Hardware.Robot;

public class Environement {
 
	// attributs 
	protected Robot rob;
	protected ArrayList<Element> elems;
	protected int sizeX;
	protected int sizeY;
	
	// constructeur 
	
	Environement(int nsizeX, int nsizeY){
		this.sizeX=nsizeX;
		this.sizeY=nsizeY;
	}
	
	//méthodes 
	public void addRobot(Robot r){
		this.rob = r;
	}
	
	public void addElem(Element e){
		this.elems.add(e);
	}
	
	public int getSizeX() {
		return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}
	
	public ArrayList<Element> getElems(){
		return elems;
	}
	
	public void removeElem(Element e) {
		if (elems.remove(e) == false) {
			System.out.println("l'élément à supprimer n'existe pas dans la liste");
		}
	}
	
	public String toString() {
		return ("l'environement a une taille de" + this.sizeX + "sur" + this.sizeY + "et contient" + this.elems.size()+"elements");
	}
}

