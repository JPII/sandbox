import java.awt.*;

public class AircraftCarrier {

	private int centerx;
	private int centery;
	public final int NORTH = 0;
	public final int SOUTH = 180;
	public final int EAST = 270;
	public final int WEST = 90;
	
	private int color;
	
	public AircraftCarrier(int x, int y,int color){
		centerx = x;
		centery = y;
		this.color=color;
	}
	
	public int getX(){
		return centerx;
	}
	public int getY(){
		return centery;
	}
	public void addX(int x)
	{
		centerx += x;
	}
	public void addY(int y)
	{
		centery += y;
	}

	public void drawShip(Graphics g){
		base(g);
	}
	
	private void base(Graphics g)
	{	
		//x and y are the center of the ship
		
		//Upper Deck
		g.setColor(Color.gray.brighter());
		int xarray[] = {centerx-150, centerx-100, centerx-75, centerx+100, centerx+150, centerx+150, centerx-150, centerx-150};
		int yarray[] = {centery-10,  centery-10,  centery-25, centery-25,  centery-10,  centery+25,  centery+25,  centery-10};
		g.fillPolygon(xarray,yarray,8);
		g.setColor(Color.black);
		g.drawPolygon(xarray,yarray,8);
		
		//lines
		g.setColor(Color.yellow);
		for(int q = centerx-145; q <= centerx+145; q += 25)
			g.fillRect(q,centery+5,18,3);
		
		//Command Center
		g.setColor(getColor().darker());
		g.fillRect(centerx+85,centery-23,15,15);
		g.setColor(getColor());
		g.fillRect(centerx+90,centery-25,2,20);		
	}
	
	private Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
