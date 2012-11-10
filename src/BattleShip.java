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
		Base(g);
		Guns(g);
		CommandCenter(g);
	}
	
	public void Base(Graphics g)
	{	
		g.setColor(Color.gray);
		g.fillArc(X+200, Y+300, 150, 50, 90, 180);
		g.fillArc(X+425, Y+300, 150, 50, 270, 180);
		Polygon p = new Polygon();
		p.addPoint(X+270,Y+300);
		p.addPoint(X+500,Y+300);
		p.addPoint(X+500,Y+350);
		p.addPoint(X+270,Y+350);
		p.addPoint(X+270,Y+300);
		g.fillPolygon(p);
		g.setColor(Color.gray.brighter());
		for(int q = 300; q <= 304; q++)
		{
			g.drawArc(X+205, Y+q, 125, 40, 180, 90);
			g.drawArc(X+436, Y+q, 130, 40, 270, 90);
		}
		for(int q = 340; q <= 345; q++)
			g.drawLine(X+267,Y+q,X+500,Y+q);
	}
	
	public void Guns(Graphics g)
	{
		//gun left
		g.setColor(Color.black);
		g.fillRect(X+206, Y+315, 20, 5);
		g.fillRect(X+206, Y+325, 20, 5);
		g.setColor(Color.gray.darker().darker());
		g.fillRect(X+208, Y+317, 20, 2);
		g.fillRect(X+208, Y+327, 20, 2);
		g.setColor(Color.black);
		g.fillOval(X+220, Y+310, 26, 26);
		g.setColor(new Color(70,70,70));
		g.fillOval(X+223, Y+313, 20, 20);
		
		//gun right
		g.setColor(Color.black);
		g.fillRect(X+545, Y+315, 20, 5);
		g.fillRect(X+545, Y+325, 20, 5);
		g.setColor(Color.gray.darker().darker());
		g.fillRect(X+545, Y+317, 20, 2);
		g.fillRect(X+545, Y+327, 20, 2);
		g.setColor(Color.black);
		g.fillOval(X+525, Y+310, 26, 26);
		g.setColor(new Color(70,70,70));
		g.fillOval(X+528, Y+313, 20, 20);
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
