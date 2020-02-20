package Simulateur;
import java.awt.*;
import javax.swing.*;
import Piece.Environement;
import Piece.Element;

public class IHMRoomba extends JPanel {
	
	//Attribut
	private Environement env;
	
	//Constructeur 
	
	IHMRoomba (Environement nenv){
		this.env = nenv;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D g3 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fillRect(prev_x,prev_y,40,40);
		g2.setColor(Color.red);
		g2.fillOval(x, y, 40, 40);
		g3.setColor(Color.blue);
		g3.fillRect(100, 100, 40, 30);
		g2.dispose();
		g3.dispose();
		prev_x=x;
		prev_y=y;
	}
	
	public void draw(Element e) {
		
	}
}
