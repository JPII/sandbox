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
	Ship test2;
	
	public BattleShip(){
		test = new Ship(400,350,1);
		test2 = new Ship(400,250,2);
		init();
	}
	public void init()
	{
		reset();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_LEFT){
					test.setX(test.getX()-50);
					test2.setX(test2.getX()-50);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_RIGHT){
					test.setX(test.getX()+50);
					test2.setX(test2.getX()+50);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_UP){
					test.setY(test.getY()-50);
					test2.setY(test2.getY()-50);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_DOWN){
					test.setY(test.getY()+50);
					test2.setY(test2.getY()+50);
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
		
		MouseMotionListener mouse1 = new MouseAdapter() {public void mouseMoved(MouseEvent md){mouseM(md);}};
		this.addMouseMotionListener(mouse1);

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
		test.drawShip(g);
		test2.drawShip(g);
		g2.drawImage(i,0,0,this);
		if (test.moving || test2.moving){
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
	public void mouseM(MouseEvent e){
    	int x = e.getX();
    	int y = e.getY();
    	test.giveXandY(x,y);
    	test2.giveXandY(x,y);
    	repaint();
    }	
}
