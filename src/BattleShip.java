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
	
	Image grid;
	
	public BattleShip(){
		test = new Ship(400,350,30,1);
		test2 = new Ship(400,250,30,2);
		init();
	}
	public void init()
	{
		grid = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
		Graphics gs = grid.getGraphics();
		gs.setColor(Color.black);
		for (int x = 0; x < 800; x += 50) {
			gs.drawLine(x,0,x,600);
		}
		for (int y = 0; y < 600; y += 50){
			gs.drawLine(0,y,800,y);
		}
		
		reset();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_LEFT){
					test.addX(-50);
					test2.addX(-50);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_RIGHT){
					test.addX(50);
					test2.addX(50);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_UP){
					test.addY(-50);
					test2.addY(-50);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_DOWN){
					test.addY(50);
					test2.addY(50);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_PAGE_DOWN){
					test.addSize(5);
					test2.addSize(5);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_PAGE_UP){
					test.addSize(-5);
					test2.addSize(-5);
					repaint();
				}
				if(k.getKeyCode() == KeyEvent.VK_HOME){
					test = new Ship(400,350,30,1);
					test2 = new Ship(400,250,30,2);
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
		g.drawImage(grid, 8,30, null);
		g.setColor(Color.black);
		g.drawString("Left moves the ship left", 50, 100);
		g.drawString("Right moves the ship right",50, 125);
		g.drawString("Down moves the ship down", 50, 150);
		g.drawString("Up moves the ship up", 50, 175);
		test.drawShip(g);
		test2.drawShip(g);
		g2.drawImage(i,0,0,this);
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
