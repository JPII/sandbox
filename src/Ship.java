import java.awt.Color;
import java.awt.Graphics;

public class Ship {
	
	private int x,y;
	private int gunRotation;
	private int beta;
	
	public final int NORTH = 0;
	public final int SOUTH = 180;
	public final int EAST = 270;
	public final int WEST = 90;
	
	private int gunSize = 4;
	private int size;
	public boolean moving;
	private boolean mouseEnabled;
	private int color;
	
	private int mousex,mousey;
	
	public Ship(int x, int y,int color){
		setX(x);
		setY(y);
		this.gunRotation = WEST;
		beta=gunRotation;
		size = 30;
		moving = false;
		mouseEnabled = true;
		this.color=color;
	}
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
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
	
	public void setRotation(int theta){
		gunRotation = theta;
	}
	
	public void giveXandY(int x, int y){
		mousex=x;
		mousey=y;
	}
	
	private void base(Graphics g)
	{	
		//x and y are the center of the ship
		//size will be in increments of 5
		
		//Bow
		g.setColor(new Color(255,211,155));
		g.setColor(Color.gray.brighter());
		g.fillArc((x-125)-115,y-25,250,50,90,180);
		g.setColor(Color.black);
		g.drawArc((x-125)-115,y-25,250,50,90,180);
		
		//Stern
		g.setColor(new Color(255,211,155));
		g.setColor(Color.gray.brighter());
		g.fillArc((x+180)-115,y-25,100,50,270,180);
		g.setColor(Color.black);
		g.drawArc((x+180)-115,y-25,100,50,270,180);
		
		//Deck
		g.setColor(new Color(255,211,155));
		g.setColor(Color.black);
		g.drawRect(x-115,y-25,230,50);
		g.setColor(Color.gray.brighter());
		g.fillRect(x-115,y-24,231,49);
		
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillRect(x-50,y-14,70,30);
		g.setColor(getColor().darker());
		g.fillRect(x-35,y-18,5,40);
		g.fillRect(x-40,y-10,5,21);
		g.fillRect(x-15,y-9,30,20);
		g.setColor(getColor());
		g.fillArc(x-25,y-10,20,20,90,180);
		g.setColor(getColor().darker());
		int xarray[] = {x-15,x-25,x-15,x-15};
		int yarray[] = {y-9,y+1,y+10,y-9};
		g.fillPolygon(xarray,yarray,4);
	}
	
	private void guns(Graphics g,int rotation)
	{
		drawGun(g,x-100,y,rotation);
		drawGun(g,x-170,y,rotation);
		drawGun(g,x+60,y,rotation);
		drawGun(g,x+130,y,rotation);
	}
	
	private int getCos(int size,int gunRotation){
		return (int) (size*Math.cos(Math.toRadians(gunRotation)));
	}
	private int getSin(int size, int gunRotation){
		return (int) (size*Math.sin(Math.toRadians(gunRotation)));
	}
	
	private void drawGun(Graphics g,int x, int y,int rotation) {
		if(mouseEnabled){
			double ycomp = y-mousey;
	    	double xcomp = x-mousex;
	    	double theta = Math.toDegrees((Math.atan(ycomp/xcomp)));
	    	rotation = (int)theta;
	    	rotation+=90;
	    	if(xcomp<0)
	    		rotation+=180;
		}
		
		int cvalue = getCos(size,rotation);
		int svalue = getSin(size,rotation);		 
		int yoffset = (cvalue+svalue)/2;
		int offset = -1*(cvalue-svalue)/2;
		
		g.setColor(Color.gray.darker());
		int xarray[] = {x-offset,x+svalue-offset,x+svalue-cvalue-offset,x-cvalue-offset};
		int yarray[] = {y+yoffset,y-cvalue+yoffset,y-cvalue-svalue+yoffset,y-svalue+yoffset};
		g.fillPolygon(xarray,yarray,4);
		
		g.setColor(Color.black);		
		int xarray2[] = {xarray[0]-getCos(size/3,rotation),xarray[0]-getCos(size/3-size/6,rotation),xarray[0]-getSin(size-size/gunSize,rotation)-getCos(size/3-size/6,rotation),xarray[0]-getSin(size-size/gunSize,rotation)-getCos(size/3,rotation)};
		int yarray2[] = {yarray[0]-getSin(size/3,rotation),yarray[0]-getSin(size/3-size/6,rotation),yarray[0]+getCos(size-size/gunSize,rotation)-getSin(size/3-size/6,rotation),yarray[0]+getCos(size-size/gunSize,rotation)-getSin(size/3,rotation)};
		g.fillPolygon(xarray2,yarray2,4);
		
		int xarray3[] = {xarray[3]+getCos(size/3,rotation),xarray[3]+getCos(size/3-size/6,rotation),xarray[3]-getSin(size-size/gunSize,rotation)+getCos(size/3-size/6,rotation),xarray[3]-getSin(size-size/gunSize,rotation)+getCos(size/3,rotation)};
		int yarray3[] = {yarray[3]+getSin(size/3,rotation),yarray[3]+getSin(size/3-size/6,rotation),yarray[3]+getCos(size-size/gunSize,rotation)+getSin(size/3-size/6,rotation),yarray[3]+getCos(size-size/gunSize,rotation)+getSin(size/3,rotation)};
		g.fillPolygon(xarray3,yarray3,4);		
	}
	
	private Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
