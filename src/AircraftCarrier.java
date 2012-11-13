import java.awt.*;

public class AircraftCarrier {

	private int x,y;
	
	public final int NORTH = 0;
	public final int SOUTH = 180;
	public final int EAST = 270;
	public final int WEST = 90;
	
	private int color;
	
	public AircraftCarrier(int x, int y,int color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void drawShip(Graphics g){
		base(g);
	}
	
	private void base(Graphics g)
	{	
		//x and y are the center of the ship
		
		//Bow
		g.setColor(Color.gray.brighter());
		
		g.setColor(Color.black);
		
		
		//Stern
		g.setColor(Color.gray.brighter());
		
		g.setColor(Color.black);
		
		
		//Deck
		g.setColor(Color.black);
		
		g.setColor(Color.gray.brighter());
		
		
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillRect(x-((30*2)-(30/3)),y-((30/2)-(30/30)),((30*2)+(30/3)),30);
		g.setColor(getColor().darker());
		g.fillRect(x-(30+(30/6)),y-((30/2)+(30/10)),30/6,30+(30/3));
		g.fillRect(x-(30+(30/3)),y-(30/3),30/6,(30-(30/3))+(30/30));
		g.fillRect(x-(30/2),y-((30/6)+(30/10)+(30/30)),30,30-(30/3));
		g.setColor(getColor());
		g.fillArc(x-(30-(30/6)),y-((30/6)+(30/10)+(30/30)),30-(30/3),30-(30/3),90,180);
		g.setColor(getColor().darker());
		int xarray[] = {x-(30/2),x-(30-(30/6)),x-(30/2),x-(30/2)};
		int yarray[] = {y-((30/6)+(30/10)+(30/30)),y+(30/15),y+(30/3)+(30/15),y-((30/6)+(30/10)+(30/30))};
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
