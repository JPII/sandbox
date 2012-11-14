import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class Exec extends JFrame
{
	Image i;
	Graphics g;
	Image i2;
	Graphics g3;
	
	BattleShip test;
	BattleShip test2;
	
	AircraftCarrier ac;
	AircraftCarrier ac2;
	
	Submarine s;
	Submarine s2;
	
	Image grid;
	
	public Exec(){
		test = new BattleShip(400,350,1);
		test2 = new BattleShip(400,250,2);
		ac = new AircraftCarrier(383,155,1);
		ac2 = new AircraftCarrier(383,455,2);
		s = new Submarine(600,300,1);
		s2 = new Submarine(200,300,2);
		init();
	}
	public void init()
	{
		grid = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
		Graphics gs = grid.getGraphics();
		gs.setColor(Color.black);
		for (int x = 0; x < 800; x += 50) {
			gs.drawLine(x+25,0,x+25,600);
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
					test = new BattleShip(400,350,1);
					test2 = new BattleShip(400,250,2);
					ac = new AircraftCarrier(400,150,1);
					ac2 = new AircraftCarrier(400,450,2);
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
		MouseListener mouse = new MouseAdapter() {public void mousePressed(MouseEvent e){mousePressed2(e);}
		public void mouseReleased(MouseEvent e){mouseReleased2(e);}};
		this.addMouseListener(mouse);
		MouseMotionListener mouse1 = new MouseAdapter() {public void mouseMoved(MouseEvent md){mouseM(md);}
		public void mouseDragged(MouseEvent md){mouseDrag(md);}};
		this.addMouseMotionListener(mouse1);

		g = newBackground();
		g3 = newForeground();
	}
	public void reset() {
		g = newBackground();
		g3 = newForeground();
		repaint();
	}
	public Graphics newBackground() {
		 i = clearBuffer();
		 return i.getGraphics();
	}
	public Graphics newForeground() {
		 i2 = clearBuffer();
		 return i2.getGraphics();
	}

	public Image clearBuffer() {
		return new BufferedImage(800+16, 600+38, BufferedImage.TYPE_INT_ARGB);
	}
	public static void main(String[] args){
		Exec battleship = new Exec();
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
		ac.drawShip(g);
		ac2.drawShip(g);
		test.drawShip(g,g);
		test2.drawShip(g,g);
		s.drawShip(g);
		s2.drawShip(g);
		g.drawImage(i2,0,0,this);
		g2.drawImage(i,0,0,this);
		if(needsRepaint())
			repaint();
	}
	public void update(Graphics g) {
		paint(g);
		delay(10);
	}
	public void delay(int n){
		try {Thread.sleep(n);} catch (Exception e) {System.out.println("Sleep failed");}
	}	
	public boolean needsRepaint(){
		return(test.needsRepaint() || test2.needsRepaint());
	}
	
	
	public void mouseM(MouseEvent e){
    	int x = e.getX();
    	int y = e.getY();
    	test.MouseMoved(x,y);
    	test2.MouseMoved(x,y);
    	repaint();
    }	
	public void mouseReleased2(MouseEvent e)
	{
		repaint();
	}
	public void mousePressed2(MouseEvent e)
    {
    	int x = e.getX();
    	int y = e.getY();
    	test.MouseClicked(x,y);
    	test2.MouseClicked(x,y);
    	repaint();
    }
	public void mouseDrag(MouseEvent e)
    {
    	int x = e.getX();
    	int y = e.getY();
    	test.MouseMoved(x,y);
    	test2.MouseMoved(x,y);
    	repaint();
    }
}
