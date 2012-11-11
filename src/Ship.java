import java.awt.Color;
import java.awt.Graphics;

public class Ship {
	
	private int x,y;
	private int gunRotation;
	private int beta;
	
	public final int NORTH = 90;
	public final int SOUTH = 270;
	public final int EAST = 0;
	public final int WEST = 180;
	
	private int size;
	public boolean moving;
	
	public Ship(int x, int y){
		this.x = x;
		this.y = y;
		this.gunRotation = EAST;
		size = 30;
		moving = false;
		beta=gunRotation;
	}
	
	public void drawShip(Graphics g){
		if(!moving) {
			base(g);
			guns(g,gunRotation);
		}
		else{
			if(beta!=gunRotation){
				base(g);
				guns(g,gunRotation);
				if(beta<gunRotation)
					gunRotation --;
				else if(beta>gunRotation){
					gunRotation++;
				}
			}
			else if(beta==gunRotation){
				base(g);
				guns(g,gunRotation);
				moving = false;
			}
		}
	}
	
	public void addRotation(int theta){
		beta+=theta;
		moving = true;
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
	
	private void guns(Graphics g,int rotation)
	{
		drawGun(g,x-100,y,rotation);
		drawGun(g,x-170,y,rotation);
		drawGun(g,x+50,y,rotation);
		drawGun(g,x+100,y,rotation);
	}
	
	private int getCos(int size,int gunRotation){
		return (int) (size*Math.cos(Math.toRadians(gunRotation)));
	}
	private int getSin(int size, int gunRotation){
		return (int) (size*Math.sin(Math.toRadians(gunRotation)));
	}
	
	private void drawGun(Graphics g,int x, int y,int rotation) {
		int cvalue = getCos(size,rotation);
		int svalue = getSin(size,rotation);		 
		int yoffset = (cvalue+svalue)/2;
		int offset = -1*(cvalue-svalue)/2;
		
		g.setColor(Color.gray.darker());
		int xarray[] = {x-offset,x+svalue-offset,x+svalue-cvalue-offset,x-cvalue-offset};
		int yarray[] = {y+yoffset,y-cvalue+yoffset,y-cvalue-svalue+yoffset,y-svalue+yoffset};
		g.fillPolygon(xarray,yarray,4);
		
		g.setColor(Color.black);		
		int xarray2[] = {xarray[0]-getCos(size/3,rotation),xarray[0]-getCos(size/3-size/6,rotation),xarray[0]-getSin(size-size/10,rotation)-getCos(size/3-size/6,rotation),xarray[0]-getSin(size-size/10,rotation)-getCos(size/3,rotation)};
		int yarray2[] = {yarray[0]-getSin(size/3,rotation),yarray[0]-getSin(size/3-size/6,rotation),yarray[0]+getCos(size-size/10,rotation)-getSin(size/3-size/6,rotation),yarray[0]+getCos(size-size/10,rotation)-getSin(size/3,rotation)};
		g.fillPolygon(xarray2,yarray2,4);
		
		int xarray3[] = {xarray[3]+getCos(size/3,rotation),xarray[3]+getCos(size/3-size/6,rotation),xarray[3]-getSin(size-size/10,rotation)+getCos(size/3-size/6,rotation),xarray[3]-getSin(size-size/10,rotation)+getCos(size/3,rotation)};
		int yarray3[] = {yarray[3]+getSin(size/3,rotation),yarray[3]+getSin(size/3-size/6,rotation),yarray[3]+getCos(size-size/10,rotation)+getSin(size/3-size/6,rotation),yarray[3]+getCos(size-size/10,rotation)+getSin(size/3,rotation)};
		g.fillPolygon(xarray3,yarray3,4);		
	}
}
