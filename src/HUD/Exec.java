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
		window(g);
		for(int x = 360; x <= 440; x += 40)
			g.drawImage(button,x,550,null);
		g.drawImage(attack,360,550,null);
		g.drawImage(diplomacy,400,550,null);
		g.drawImage(move,440,550,null);
	}
	
	public void window(Graphics g){		
		for(int x = 8; x <= 788; x += 4)
			for(int y = 507; y <= 592; y += 4)
			{
			//	int r = random(60,90);
				int gr= random(85,115);
				int b = random(45,75);
				g.setColor(new Color(b,b,gr));
				g.fillRect(x,y,4,4);
			}
	}
	
	public static int random(int min, int max){
		int range = max - min + 1;
		return (int) (Math.random() * range + min);
	}
	
	public static void main(String[] args){
		Exec battleship = new Exec();
		battleship.setSize(800,600);
		battleship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleship.setVisible(true);
	}
	
	public void update(Graphics g){
		paint(g);
	}	
}