import java.awt.*;
import java.util.*;

public class Ship {
	
	private int x,y;
	
	public final int NORTH = 0;
	public final int SOUTH = 180;
	public final int EAST = 270;
	public final int WEST = 90;
	
	private ArrayList<Turret> guns;
	
	private int color;
	
	public Ship(int x, int y,int color){
		this.x=x;
		this.y=y;
		guns = new ArrayList<Turret>();
		initArray();
		this.color=color;
	}
	
	private void initArray(){
		guns.add(new Turret(x-100,y,270,0,30,WEST));
		guns.add(new Turret(x-170,y,270,0,30,WEST));
		guns.add(new Turret(x+50,y,270,0,30,WEST));
		guns.add(new Turret(x+100,y,270,0,30,WEST));
	}
	
	public void addX(int x){
		this.x+=x;
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).addX(x);
		}
	}
	public void addY(int y){
		this.y+=y;
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).addY(y);
		}
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void giveXandY(int x, int y){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).giveXandY(x,y);
		}
	}
	
	public void drawShip(Graphics g){
		base(g);
		drawGuns(g);
	}
	
	private void drawGuns(Graphics g){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).drawGun(g);
		}
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
	
	private Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
