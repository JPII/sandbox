import java.awt.*;

public class Submarine extends AircraftCarrier{
	
	public Submarine(int x, int y,int color){
		super(x,y,color);
	}
	
	protected void base(Graphics g)
	{	
		//x and y are the center of the ship
		
		//Body
		g.setColor(Color.gray.brighter());
		g.fillOval(x-115/2, y-25/2, 100, 25);
		g.setColor(Color.black);
		g.drawOval(x-115/2, y-25/2, 100, 25);	
				
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillOval(x-14, y-6, 15, 15);
		g.setColor(getColor().darker());
		g.fillRect(x-7, y-12, 3, 25);
	}
}
