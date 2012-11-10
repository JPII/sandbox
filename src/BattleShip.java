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
		//Base(g);
		gun(g,X+230,Y+310,30,1);
		gun(g,X+270,Y+310,30,2);
		gun(g,X+270,Y+390,30,3);
		gun(g,X+230,Y+390,30,4);
		//CommandCenter(g);
	}
	
	public void Base(Graphics g)
	{	
		//Bow
		g.setColor(new Color(255,211,155));
		g.fillArc(X+145, Y+300, 250, 50, 90, 180);
		
		//Stern
		g.setColor(Color.gray);
		g.fillArc(X+450, Y+300, 100, 50, 270, 180);
		
		//Deck
		g.setColor(new Color(255,211,155));
		g.fillRect(X+270,Y+300,230,50);
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
	
	public void CommandCenter(Graphics g)
	{
		g.setColor(Color.gray.darker().darker());
		g.fillRect(X+350,Y+310,70,30);
		g.setColor(Color.gray.darker());
		g.fillRect(X+365,Y+305,15,40);
		g.fillRect(X+385,Y+315,30,20);
	}
}
