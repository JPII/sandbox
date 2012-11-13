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
		
		//Upper Deck
		g.setColor(Color.gray.brighter());
		int xarray[] = {x-150,x-50,x-15,x+65,x+80,x+150,x+150,x-150};
		int yarray[] = {y-25,y-25,y-65,y-70,y-25,y-25,y+25,y+25};
		g.fillPolygon(xarray,yarray,8);
		g.setColor(Color.black);
		g.drawPolygon(xarray,yarray,8);
		
		//lines
		g.setColor(Color.yellow);
		for(int q = x-145; q <= x+145; q += 30)
			g.fillRect(q, y, 20, 3);
		
		
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillRect(x+40,y+7,15,15);
		g.setColor(getColor().darker());
		g.fillRect(x+45,y+5,3,20);		
	}
	
	private Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
