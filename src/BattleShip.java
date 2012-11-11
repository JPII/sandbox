import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BattleShip extends JFrame
{
	int X = 8;
	int Y = 5;
	
	Ship test;
	
	public BattleShip(){
		test = new Ship(400,300);
	}
	public static void main(String[] args){
		BattleShip battleship = new BattleShip();
		battleship.setSize(800,600);
		battleship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleship.setVisible(true);
	}
	
	public void paint(Graphics g){
		test.drawShip(g);
	}
	
}
