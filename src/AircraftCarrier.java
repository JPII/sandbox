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
		int xarray[] = {x-150, x-100, x-75, x+100, x+150, x+150, x-150, x-150};
		int yarray[] = {y-10,  y-10,  y-25, y-25,  y-10,  y+25,  y+25,  y-10};
		g.fillPolygon(xarray,yarray,8);
		g.setColor(Color.black);
		g.drawPolygon(xarray,yarray,8);
		
		//lines
		g.setColor(Color.yellow);
		for(int q = x-145; q <= x+145; q += 25)
			g.fillRect(q,y+5,18,3);
		
		//Command Center
		g.setColor(getColor().darker());
		g.fillRect(x+85,y-23,15,15);
		g.setColor(getColor());
		g.fillRect(x+90,y-25,2,20);		
	}
	
	private Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
