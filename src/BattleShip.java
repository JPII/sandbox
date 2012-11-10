import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BattleShip extends JFrame
{
	int X = 8;
	int Y = 5;
			
	public BattleShip(){
		
	}
	public static void main(String[] args){
		BattleShip battleship = new BattleShip();
		battleship.setSize(800,600);
		battleship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleship.setVisible(true);
	}
	
	public void paint(Graphics g){
		Base(g,X+400,Y+300);
		gun(g,X+300,Y+285,30,1);
		gun(g,X+230,Y+285,30,4);
		gun(g,X+450,Y+285,30,2);
		gun(g,X+500,Y+285,30,3);
	}
	
	public void Base(Graphics g, int x, int y)
	{	
		//x and y are the center of the ship
		//size will be in increments of 5
		
		//Bow
		g.setColor(new Color(255,211,155));
		g.fillArc((x-125)-115,y-25,250,50,90,180);
		
		//Stern
		g.setColor(new Color(255,211,155));
		g.fillArc((x+180)-115,y-25,100,50,270,180);
		
		//Deck
		g.setColor(new Color(255,211,155));
		g.fillRect(x-115,y-25,230,50);
		
		//Command Center
		g.setColor(Color.gray.darker().darker());
		g.fillRect(x-50,y-14,70,30);
		g.setColor(Color.gray.darker());
		g.fillRect(x-35,y-18,15,40);
		g.fillRect(x-15,y-9,30,20);
	}
	
	public void gun(Graphics g, int x, int y, int size, int d)
	{
		if(d == 1)
		{
			g.setColor(Color.gray.darker());
			g.fillRect(x,y,size,size);
			g.setColor(Color.black);
			g.fillRect(x+(size/6), y-(size-(size/10)), size/6, size-(size/10));
			g.fillRect(x+(size-(size/3)), y-(size-(size/10)), size/6, size-(size/10));
		}
		else if(d == 2)
		{
			g.setColor(Color.gray.darker());
			g.fillRect(x,y,size,size);
			g.setColor(Color.black);
			g.fillRect(x+(size/6), y+size, size/6, size-(size/10));
			g.fillRect(x+(size-(size/3)), y+size, size/6, size-(size/10));
		}
		else if(d == 3)
		{
			g.setColor(Color.gray.darker());
			g.fillRect(x,y,size,size);
			g.setColor(Color.black);
			g.fillRect(x+size, y+(size/6), size-(size/10), size/6);
			g.fillRect(x+size, y+(size-(size/3)), size-(size/10), size/6);
		}
		else if(d == 4)
		{
			g.setColor(Color.gray.darker());
			g.fillRect(x,y,size,size);
			g.setColor(Color.black);
			g.fillRect(x-(size-(size/10)), y+(size/6), size-(size/10), size/6);
			g.fillRect(x-(size-(size/10)), y+(size-(size/3)), size-(size/10), size/6);
		}
	}
}
