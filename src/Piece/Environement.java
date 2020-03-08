package Piece;
import java.awt.Color;
import java.util.ArrayList;
import Piece.Element;
import Hardware.Robot;

/**
 * 
 * Classe Environnement : définit l'environnement de la simulation. 
 * l'environnement est définit par sa taille, le Robot et les Elements qu'il contient
 *
 */
public class Environement {
 
	// attributs 
	private Robot rob;
	private ArrayList<Element> elems;
	private int sizeX;
	private int sizeY;
	
	// constructeur 
	
	/**
	 * Constructeur
	 */
	/**
	 * le constructeur instancie sizeX et sizeY
	 * il créee une liste d'Elements vide
	 * @param nsizeX taille en pixel de l'enironnement selon l'axe X
	 * @param nsizeY taille en pixel de l'enironnement selon l'axe Y
	 */
	 public Environement(int nsizeX, int nsizeY){
		this.sizeX=nsizeX;
		this.sizeY=nsizeY;
		this.elems = new ArrayList<Element>();
	}
	
	//méthodes
	/**
	 * Méthode qui ajoute un robot à l'environnement 
	 */
	public void addRobot(Robot r){
		this.rob = r;
	}
	
	/**
	 * Méthode qui ajoute l'élément e à la liste d'Elment indépendemment de s'il sagit d'une tache ou d'un obstacle
	 * @param e Element à ajouter
	 */
	public void addElem(Element e){
		this.elems.add(e);
	}
	
	/**
	 * getter
	 * @return la taille selon X de l'environement
	 */
	public int getSizeX() {
		return this.sizeX;
	}
	
	/**
	 * getter
	 * @return la taille selon Y de l'environement
	 */
	public int getSizeY() {
		return this.sizeY;
	}
	
	/**
	 * getter
	 * @return l'objet Robot de l'environement
	 */
	public Robot getRobot() {
		return this.rob;
	}
	
	/**
	 * getter
	 * @return la liste des Elements de l'environement
	 */
	public ArrayList<Element> getElems(){
		return elems;
	}
	
	/**
	 * Méthode qui supprime l'Element e de la liste des Elements de l'environnement 
	 * si l'élement n'existe pas dans la liste un message d'erreur d'affiche 
	 * @param e Element à supprimer de la liste
	 */
	public void removeElem(Element e) {
		if (elems.remove(e) == false) {
			System.out.println("l'élément à supprimer n'existe pas dans la liste");
		}
	}
	
	/**
	 * Méthode qui compte le  nombre de Taches de la liste d'Elements
	 * @return le nombre de Taches de la liste d'Elements
	 */
	public int getNbTaches () {
		int res = 0;
		for (int i =0; i<this.elems.size(); i++) {
			if (this.elems.get(i).getIsSolid()== false && this.elems.get(i).getColor()!=Color.white) {
				res++;
			}
		}
		return res;
	}
	
	/**
	 * Méthode toString: retourne un string contenant la taille de l'environnement et le nombre d'éléments qu'il contient 
	 */
	public String toString() {
		return ("l'environement a une taille de " + this.sizeX + " sur " + this.sizeY + " et contient " + this.elems.size()+" elements");
	}
}

