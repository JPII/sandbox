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
		is.drawAircraftCarrier(g,x,y);
	}

	public void MouseMoved(int x, int y) {	
	}

	public void MouseClicked(int x, int y) {
	}
}
