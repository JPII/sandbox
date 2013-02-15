package HUD;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

@SuppressWarnings("serial")
public class Exec extends JFrame
{	
	Image button,attack,diplomacy,move;
	
	public Exec(){
		try{
			button 		= ImageIO.read(Exec.class.getResource("staticButton.png"));
			attack 		= ImageIO.read(Exec.class.getResource("Attack.png"));
			diplomacy	= ImageIO.read(Exec.class.getResource("Diplomacy.png"));
			move		= ImageIO.read(Exec.class.getResource("Move.png"));
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,800,600);
		for(int x = 100; x <= 180; x += 40)
			g.drawImage(button,x,100,null);
		g.drawImage(attack,100,100,null);
		g.drawImage(diplomacy,140,100,null);
		g.drawImage(move,180,100,null);
	}
	
	public static void main(String[] args){
		Exec battleship = new Exec();
		battleship.setSize(800,600);
		battleship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleship.setVisible(true);
	}
	
	public void update(Graphics g) {
		paint(g);
	}	
}
