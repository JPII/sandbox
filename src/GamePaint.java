import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class GamePaint extends JComponent implements MouseListener{
	int width, height;
	BufferedImage buffer,background;
	Timer timer;
	int ticksize = 0;
	long ticks = 0;
	public ArrayList<BaseTank> ships;
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
		ships = new ArrayList<BaseTank>();
		keys = new ArrayList<KeyEvent>();
		ships.add(new Bird(100,150,0));
		
		background = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = background.getGraphics();
		
		for(int k = 0; k<height; k+=ImageStorage.getSand().getHeight(null)){	
			for(int i = 0; i<width; i+=ImageStorage.getSand().getWidth(null)){
				g.drawImage(ImageStorage.getSand(),i,k,null);
			}
		}
	}
	
	public void tick() {
		buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = buffer.getGraphics();
		g.drawImage(background,0,0,null);
		
		for(int index = 0; index<ships.size();index++){
			ships.get(index).drawShip(g);
			ships.get(index).checkPhysics();
		}
		
		g.setColor(Color.red);
		g.drawLine(x, y, x, y);
	}
	
	public void getKeys(){
		boolean akey=false;
		int addx=0;
		int addy=0;
		for(int index = 0; index<keys.size();index++){
			akey=true;
			KeyEvent current = keys.get(index);
			if(current.getKeyCode()==KeyEvent.VK_LEFT || current.getKeyCode()==KeyEvent.VK_A){
				addx+=-1;
				for(int count = 0; count<ships.size();count++){
					ships.get(selected).MouseMoved(x,y);
				}
			}
			if(current.getKeyCode()==KeyEvent.VK_RIGHT || current.getKeyCode()==KeyEvent.VK_D){
				addx+=1;
				for(int count = 0; count<ships.size();count++){
					ships.get(selected).MouseMoved(x,y);
				}
			}
			if(current.getKeyCode()==KeyEvent.VK_UP || current.getKeyCode()==KeyEvent.VK_W){
				addy+=-1;
				for(int count = 0; count<ships.size();count++){
					ships.get(selected).MouseMoved(x,y);
				}
			}
			if(current.getKeyCode()==KeyEvent.VK_DOWN || current.getKeyCode()==KeyEvent.VK_S){
				addy+=1;
				for(int count = 0; count<ships.size();count++){
					ships.get(selected).MouseMoved(x,y);
				}
			}
		}
		if(akey){
			for(int count = 0; count<ships.size();count++){
				ships.get(selected).move(addx,addy);
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
		x = e.getX();
    	y = e.getY();
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

