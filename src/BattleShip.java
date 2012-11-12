import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class BattleShip extends JFrame
{
	Image i;
	Graphics g;
	
	Ship test;
	
	public BattleShip(){
		test = new Ship(400,300);
		init();
	}
	public void init()
	{
		reset();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_Z) {
					rotate(-5);
				}
				if(k.getKeyCode() == KeyEvent.VK_Q) {
					rotate(360);
				}
				if(k.getKeyCode() == KeyEvent.VK_E) {
					rotate(-360);
				}
				if(k.getKeyCode() == KeyEvent.VK_X) {
					rotate(5);
				}
				if(k.getKeyCode() == KeyEvent.VK_LEFT){
					if(test.getX() >= 260){
						test.setX(test.getX()-10);
						repaint();
					}
				}
				if(k.getKeyCode() == KeyEvent.VK_RIGHT){
					if(test.getX() <= 610){
						test.setX(test.getX()+10);
						repaint();
					}
				}
				if(k.getKeyCode() == KeyEvent.VK_UP){
					if(test.getY() >= 70){
						test.setY(test.getY()-10);
						repaint();
					}
				}
				if(k.getKeyCode() == KeyEvent.VK_DOWN){
					if(test.getY() <= 550)
					test.setY(test.getY()+10);
					repaint();
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});

		g = newBackground();
	}
	public void reset() {
		g = newBackground();
		repaint();
	}
	public Graphics newBackground() {
		 i = clearBuffer();
		 return i.getGraphics();
	}

	public Image clearBuffer() {
		return new BufferedImage(800+16, 600+38, BufferedImage.TYPE_INT_ARGB);
	}
	public static void main(String[] args){
		BattleShip battleship = new BattleShip();
		battleship.setSize(800,600);
		battleship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleship.setVisible(true);
	}
	
	
	public void paint(Graphics g2){
		g.setColor(Color.white);
		g.fillRect(0,0,800,600);
		g.setColor(Color.black);
		g.drawString("Left moves the ship left", 50, 100);
		g.drawString("Right moves the ship right",50, 125);
		g.drawString("Down moves the ship down", 50, 150);
		g.drawString("Up moves the ship up", 50, 175);
		g.drawString("'Z' rotates the guns counter-clockwise", 50, 200);
		g.drawString("'X' rotates the guns clockwise", 50, 225);
		g.drawString("'Q' rotates the guns for quite awhile", 50, 250);
		test.drawShip(g);
		g2.drawImage(i,0,0,this);
		if (test.moving){
			repaint();
		}
	}
	public void update(Graphics g) {
		paint(g);
		delay(10);
	}
	public void delay(int n){
		try {Thread.sleep(n);} catch (Exception e) {System.out.println("Sleep failed");}
	}
	public void rotate(int degrees){
		test.addRotation(degrees);
		repaint();
	}
	
}
