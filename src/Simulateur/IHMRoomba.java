package Simulateur;
import java.awt.*;
import javax.swing.*;
import Piece.Environement;
import Piece.Element;
public class IHMRoomba extends JPanel {
	
	//Attribut
	private Environement env;
	//private JFrame ma_fenetre;
	
	//Constructeur 
	
	IHMRoomba (Environement nenv){
		this.env = nenv;
	
		/*this.ma_fenetre = new JFrame();
		this.ma_fenetre.setTitle("roomba simulation");
		this.ma_fenetre.setSize(env.getSizeX(),env.getSizeY());
		this.ma_fenetre.setLocationRelativeTo(null);
		this.ma_fenetre.setResizable(false);
		this.ma_fenetre.setBackground(Color.white);
		this.ma_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ma_fenetre.setVisible(true);*/
		
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i =0; i<env.getElems().size();i++) {
			g2.setColor(env.getElems().get(i).getColor());
			System.out.println(env.getElems().get(i));
			g2.fillOval(100*i, 100*i, 50, 50);
		}
		//g2.setColor(Color.black);
		//g2.fillOval(100, 100, 40, 40);
		/*g2.fillRect(prev_x,prev_y,40,40);
		g2.setColor(Color.red);
		g2.fillOval(x, y, 40, 40);
		g2.dispose();
		prev_x=x;
		prev_y=y;
		g2.fillOval(20,20,75,75);*/
	}
	
	
}
