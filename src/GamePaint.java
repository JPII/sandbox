import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class GamePaint extends JComponent implements MouseListener{
	int width, height;
	BufferedImage buffer;
	Timer timer;
	int ticksize = 5;
	long ticks = 0;
	public ArrayList<Ship> ships;
	public ArrayList<KeyEvent> keys;
	int selected = 0;
	ActionListener al;
	int x,y;
	
	public GamePaint(int width, int height) {
		addMouseListener(this);
		this.width = width;
		this.height = height;
		setSize(width,height);
		init();
		 al = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getKeys();
				tick();
				repaint();
				ticks+= ticksize;
			}
		};
		MouseMotionListener mouse1 = new MouseAdapter() {public void mouseMoved(MouseEvent md){mouseMoved2(md);}
		public void mouseDragged(MouseEvent md){mouseDragged2(md);}};
		this.addMouseMotionListener(mouse1);
	}
	
	public void init(){
		ships = new ArrayList<Ship>();
		keys = new ArrayList<KeyEvent>();
		ships.add(new Tank(400,350,3,0));
	}
	
	public void tick() {
		buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = buffer.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		for(int index = 0; index<ships.size();index++){
			ships.get(index).drawShip(g);
		}
	}
	
	public void getKeys(){
		for(int index = 0; index<keys.size();index++){
			KeyEvent current = keys.get(index);
			if(current.getKeyCode()==KeyEvent.VK_LEFT || current.getKeyCode()==KeyEvent.VK_A){
				for(int count = 0; count<ships.size();count++){
					ships.get(count).addX(-1);
					ships.get(selected).MouseMoved(x,y);
				}
			}
			if(current.getKeyCode()==KeyEvent.VK_RIGHT || current.getKeyCode()==KeyEvent.VK_D){
				for(int count = 0; count<ships.size();count++){
					ships.get(count).addX(1);
					ships.get(selected).MouseMoved(x,y);
				}
			}
			if(current.getKeyCode()==KeyEvent.VK_UP || current.getKeyCode()==KeyEvent.VK_W){
				for(int count = 0; count<ships.size();count++){
					ships.get(count).addY(-1);
					ships.get(selected).MouseMoved(x,y);
				}
			}
			if(current.getKeyCode()==KeyEvent.VK_DOWN || current.getKeyCode()==KeyEvent.VK_S){
				for(int count = 0; count<ships.size();count++){
					ships.get(count).addY(1);
					ships.get(selected).MouseMoved(x,y);
				}
			}
		}
	}
	public void start() {
		timer = new Timer(ticksize,al);
		timer.start();
	}
	public void stop() {
	}
	public BufferedImage getImage() {
		return buffer;
	}
	public void paintComponent(Graphics g) {
		g.drawImage(buffer, 0, 0, null);
	}
	public void mouseClicked(MouseEvent arg0) {	
	}
	public void mouseEntered(MouseEvent arg0) {	
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		ships.get(selected).MouseClicked(x,y);
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	public void mouseDragged2(MouseEvent e) {
		x = e.getX();
    	y = e.getY();
    	ships.get(selected).MouseMoved(x,y);
	}
	public void mouseMoved2(MouseEvent e) {
		x = e.getX()-8;
    	y = e.getY()-32;
    	ships.get(selected).MouseMoved(x,y);
	}
	public void pressed(KeyEvent k) {
		for(int index = 0; index<keys.size();index++){
			KeyEvent current = keys.get(index);
			if(current.getKeyCode()==(k.getKeyCode())){
				return;
			}
		}
		keys.add(k);
	}
	public void released(KeyEvent k) {
		for(int index = 0; index<keys.size();index++){
			KeyEvent current = keys.get(index);
			if(current.getKeyCode()==(k.getKeyCode())){
				keys.remove(index);
				return;
			}
		}
	}
}

