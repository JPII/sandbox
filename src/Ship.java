import java.awt.Color;
import java.awt.Graphics;

public class Ship {
	
	private int x,y;
	private int gunRotation;
	
	public final int NORTH = 90;
	public final int SOUTH = 270;
	public final int EAST = 0;
	public final int WEST = 180;
	
	private int size;
	
	public Ship(int x, int y){
		this.x = x;
		this.y = y;
		this.gunRotation = EAST;
		size = 30;
	}
	
	public void drawShip(Graphics g){
		base(g);
		guns(g);
		gunRotation+=10;
	}
	
	private void base(Graphics g)
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
	
	private void guns(Graphics g)
	{
		drawGun(g,x-100,y);
		//drawGun(g,x-170,y);
		//drawGun(g,x+50,y);
		//drawGun(g,x+100,y);
	}
	
	private int getCos(int size){
		return (int) (size*Math.cos(Math.toRadians(gunRotation)));
	}
	private int getSin(int size){
		return (int) (size*Math.sin(Math.toRadians(gunRotation)));
	}
	
	private void drawGun(Graphics g,int x, int y) {
		int cvalue = getCos(size);
		int svalue = getSin(size);		 
		int yoffset = (cvalue+svalue)/2;
		int offset = -1*(cvalue-svalue)/2;
		
		int xarray[] = {x-offset,x+svalue-offset,x+svalue-cvalue-offset,x-cvalue-offset};
		int yarray[] = {y+yoffset,y-cvalue+yoffset,y-cvalue-svalue+yoffset,y-svalue+yoffset};
		
		g.setColor(Color.gray.darker());
	//	g.fillRect(x-size/2,y-size/2,size,size);
		g.fillPolygon(xarray,yarray,4);
		
		g.setColor(Color.black);
	//	g.fillRect(x+(size/6) - size/2, y-(size-(size/10)) - size/2, size/6, size-(size/10));
	//	g.fillRect(x+(size-(size/3)) - size/2, y-(size-(size/10)) - size/2, size/6, size-(size/10));
		
		int xarray2[] = {xarray[0]-getCos(size/3),xarray[0]-getCos(size/3+size/6),xarray[0]-getCos(size/3+size/6),xarray[0]-getCos(size/3)};
		int yarray2[] = {yarray[0]-getSin(size/3),yarray[0]-getSin(size/3+size/6),yarray[0]+getCos(size-size/10),yarray[0]+getCos(size-size/10)};
		g.fillPolygon(xarray2,yarray2,4);
		
		g.setColor(Color.red);
		g.fillRect(x-2, y-2, 4, 4);
		
		g.setColor(Color.blue);
		g.fillRect(xarray2[2]-2, yarray2[2]-2, 4, 4);
		
		
	}
}
