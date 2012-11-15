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
		guns.add(new Turret(x-((size*3)+(size/3)),y,270,0,size,WEST));
		guns.add(new Turret(x-((size*6)-(size/3)),y,270,0,size,WEST));
		guns.add(new Turret(x+((size*2)-(size/3)),y,270,0,size,WEST));
		guns.add(new Turret(x+((size*3)+(size/3)),y,270,0,size,WEST));
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
		g.fillArc(x-(size*8),y-(size-(size/6)),(size*8)+(size/3),(size*2)-(size/3),90,180);
		g.setColor(Color.black);
		g.drawArc(x-(size*8),y-(size-(size/6)),(size*8)+(size/3),(size*2)-(size/3),90,180);
		
		//Stern
		g.setColor(Color.gray.brighter());
		g.fillArc(x+((size*2)+(size/6)),y-(size-(size/6)),(size*3)+(size/3),(size*2)-(size/3),270,180);
		g.setColor(Color.black);
		g.drawArc(x+((size*2)+(size/6)),y-(size-(size/6)),(size*3)+(size/3),(size*2)-(size/3),270,180);
		
		//Deck
		g.setColor(Color.black);
		g.drawRect(x-((size*4)-(size/6)),y-(size-(size/6)),(size*8)-(size/3),(size*2)-(size/3));
		g.setColor(Color.gray.brighter());
		g.fillRect(x-((size*4)-(size/6)),y-((size-(size/6))-1),(size*8)-(size/3)+1,(size*2)-(size/3)-1);
		
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillRect(x-((size*2)-(size/3)),y-((size/2)-(size/size)),((size*2)+(size/3)),size);
		g.setColor(getColor().darker());
		g.fillRect(x-(size+(size/6)),y-((size/2)+(size/10)),size/6,size+(size/3));
		g.fillRect(x-(size+(size/3)),y-(size/3),size/6,(size-(size/3))+(size/size));
		g.fillRect(x-(size/2),y-((size/6)+(size/10)+(size/size)),size,size-(size/3));
		g.setColor(getColor());
		g.fillArc(x-(size-(size/6)),y-((size/6)+(size/10)+(size/size)),size-(size/3),size-(size/3),90,180);
		g.setColor(getColor().darker());
		int xarray[] = {x-(size/2),x-(size-(size/6)),x-(size/2),x-(size/2)};
		int yarray[] = {y-((size/6)+(size/10)+(size/size)),y+(size/15),y+(size/3)+(size/15),y-((size/6)+(size/10)+(size/size))};
		g.fillPolygon(xarray,yarray,4);
	}
}
