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
		int w = getWidth();
		int h = getHeight();
		int y = h-45;
		g.setColor(Color.white);
		g.fillRect(0,0,w,h);
		window(g);
		for(int x = (w/2)-40; x <= (w/2)+40; x += 40)
			g.drawImage(button,x,y,null);
		g.drawImage(attack,(w/2)-40,y,null);
		g.drawImage(diplomacy,w/2,y,null);
		g.drawImage(move,(w/2)+40,y,null);
	}
	
	public void window(Graphics g){	
		int w = getWidth();
		int h = getHeight();
		for(int x = w-(w-8); x <= w; x += 4)
			for(int y = h-100; y <= h; y += 4)
			{
				int gr= random(85,115);
				int b = random(45,75);
				g.setColor(new Color(gr,b,b));
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