import java.awt.*;

public class AircraftCarrier extends BattleShip{
	
	public AircraftCarrier(int x, int y,int color){
		super(x,y);
		this.color = color;
	}

	public void drawShip(Graphics g){
		base(g);
	}
	
	protected void base(Graphics g)
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
		g.setColor(Color.white);
		for(int q = x-145; q <= x+145; q += 25)
			g.fillRect(q,y+5,18,3);
		
		//Command Center
		g.setColor(getColor().darker());
		g.fillRect(x+85,y-23,15,15);
		g.setColor(getColor());
		g.fillRect(x+90,y-25,2,20);		
	}
}
