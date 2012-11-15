import java.awt.*;
import java.util.*;

public class BattleShip extends Ship {
	private ArrayList<Turret> guns;
	public BattleShip(int x, int y,int color){
		super(x,y,color);
		guns = new ArrayList<Turret>();
		initArray();
	}	
	private void initArray(){
		guns.add(new Turret(x+70,y,270,0,size,WEST));
		guns.add(new Turret(x+35,y,270,0,size,WEST));
		guns.add(new Turret(x+145,y,270,0,size,WEST));
		guns.add(new Turret(x+170,y,270,0,size,WEST));
	}
	public void addX(int x){
		super.addX(x);
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).addX(x);
		}
	}
	public void addY(int y){
		super.addY(y);
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).addY(y);
		}
	}
	public void MouseMoved(int x, int y){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).MouseMoved(x,y);
		}
	}
	public void MouseClicked(int x, int y){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).MouseClicked(x,y);
		}
	}
	public boolean needsRepaint(){
		if(super.needsRepaint()){
			return true;
		}
		for(int index = 0; index<guns.size();index++){
			if(guns.get(index).needsRepaint()){
				return true;
			}
		}
		return false;
	}
	public void drawShip(Graphics g){
		super.drawShip(g);
		drawGuns(g);
	}
	
	private void drawGuns(Graphics g){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).drawGun(g);
		}
	}
	
	protected void base(Graphics g, int size)
	{	
		//x and y are the center of the ship
		
		//Bow
		g.setColor(Color.gray.brighter());
		g.fillArc(x,y-13,125,25,90,180);
		g.setColor(Color.black);
		g.drawArc(x,y-13,125,25,90,180);
		
		//Stern
		g.setColor(Color.gray.brighter());
		g.fillArc(x+150,y-13,50,25,270,180);
		g.setColor(Color.black);
		g.drawArc(x+150,y-13,50,25,270,180);
		
		//Deck
		g.setColor(Color.black);
		g.drawRect(x+62,y-13,112,25);
		g.setColor(Color.gray.brighter());
		g.fillRect(x+62,y-12,113,24);
		
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillRect(x+95,y-7,35,15);
		g.setColor(getColor().darker());
		g.fillRect(x+102,y-9,2,20);
		g.fillRect(x+100,y-5,2,10);
		g.fillRect(x+112,y-5,15,11);
		g.setColor(getColor());
		g.fillArc(x+105,y-6,12,12,90,180);
		g.setColor(getColor().darker());
		int xarray[] = {x+112,x+106,x+112,x+112};
		int yarray[] = {y-6,y,y+7,y-5};
		g.fillPolygon(xarray,yarray,4);
	}
}
