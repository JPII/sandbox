package HUD;

import java.awt.*;

import javax.swing.*;
import javax.imageio.*;

@SuppressWarnings("serial")
public class Exec extends JFrame
{	
	Image button,attack,diplomacy,move,battleship;
	
	public Exec(){
		try{
			button 		= ImageIO.read(Exec.class.getResource("staticButton.png"));
			attack 		= ImageIO.read(Exec.class.getResource("Attack.png"));
			diplomacy	= ImageIO.read(Exec.class.getResource("Diplomacy.png"));
			move		= ImageIO.read(Exec.class.getResource("Move.png"));
			battleship  = ImageIO.read(Exec.class.getResource("battleship.png"));
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
		shipGUI(g);
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
			for(int y = h-125; y <= h; y += 4)
			{
				int gr= random(85,115);
				int b = random(45,75);
				g.setColor(new Color(gr,b,b));
				g.fillRect(x,y,4,4);
			}
		for(int x0 = w-(((w/3)+(w/3))-8); x0 <= w-((w/3)-8)+5; x0++)
			for(int y0 = h-125; y0 <= h; y0++)
			{
				int r = random(0,250);
				g.setColor(new Color(r,r,0));
				g.fillRect(x0,y0,1,1);
			}
		g.setColor(new Color(110,110,110));
		g.fillRect(w-(((w/3)+(w/3))-8),h-125,5,125);
		g.fillRect(w-((w/3)-8)+5,h-125,5,125);
		g.setColor(new Color(170,170,170));
		g.drawLine(w-(w-8),h-125,w,h-125);
		g.setColor(new Color(155,155,155));
		g.drawLine(w-(w-8),h-124,w,h-124);
		g.setColor(new Color(140,140,140));
		g.drawLine(w-(w-8),h-123,w,h-123);
		g.setColor(new Color(125,125,125));
		g.drawLine(w-(w-8),h-122,w,h-122);
		g.setColor(new Color(110,110,110));
		g.drawLine(w-(w-8),h-121,w,h-121);
	}
	
	public void shipGUI(Graphics g){
		int w = getWidth();
		int h = getHeight();
		g.setColor(new Color(255,255,0,180));
		g.fillRect((w-(w-8))+7,h-111,27,27);
		g.fillRect((w-(w-8))+7,h-76,27,27);
		g.fillRect((w-(w-8))+7,h-41,27,27);
		g.setColor(new Color(255,255,255,180));
		g.fillRect((w-(w-8))+60,h-113,(w/4)+1,100);
		g.drawRect((w-(w-8))+5,h-113,30,30);
		g.drawRect((w-(w-8))+6,h-112,28,28);
		g.drawRect((w-(w-8))+5,h-78,30,30);
		g.drawRect((w-(w-8))+6,h-77,28,28);
		g.drawRect((w-(w-8))+5,h-43,30,30);
		g.drawRect((w-(w-8))+6,h-42,28,28);
		g.setColor(Color.red);
		g.fillRect((w-(w-8))+150,h-47,50,23);
		g.drawImage(battleship,(w-(w-8))+60,h-60,null);
		g.setColor(Color.black);
		g.drawString("Health: 100",(w-(w-8))+62,h-100);
		g.drawString("Ammo: Unlimited",(w-(w-8))+62,h-85);
		g.drawString("Upgrades: Explosive Ammo",(w-(w-8))+62,h-70);
		g.drawString("Location: 23:40",(w-(w-8))+62,h-55);
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