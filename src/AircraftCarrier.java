import java.awt.*;

public class AircraftCarrier extends Ship{
	ImageStorage is;
	
	public AircraftCarrier(int x, int y,int color){
		super(x,y,color);
		is = new ImageStorage();
	}
	
	protected void base(Graphics g, int size)
	{	
		//x and y are the center of the ship
		g.setColor(getColor());
		g.fillRect(x+225,y,25,25);
		is.drawAircraftCarrier(g,x,y);
		for(int q = 105; q <= 200; q += 30)
			is.drawJet(g,x+q,y+3);
	}

	public void MouseMoved(int x, int y) {	
	}

	public void MouseClicked(int x, int y) {
	}
}
