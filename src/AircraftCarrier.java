import java.awt.*;

public class AircraftCarrier extends Ship{
	ImageStorage is;
	
	public AircraftCarrier(int x,int y,int color,double angle){
		super(x,y,color,angle);
		is = new ImageStorage();
	}
	
	protected void base(Graphics g, int size)
	{
		int halfcellwidth = 25;
		int imgheight = is.AircraftCarrier.getHeight(null);
		is.drawAircraftCarrier((Graphics2D)g, rotate(angle,x,y,halfcellwidth,imgheight/2));
	}

	public void MouseMoved(int x, int y) {	
	}

	public void MouseClicked(int x, int y) {
	}
}
