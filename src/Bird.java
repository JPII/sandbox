import java.awt.*;
import java.awt.image.BufferedImage;


public class Bird extends BaseTank{
	
	private double centerx;
	private double centery;
	private int rotation;
	private int shipRotation;
	
	public Bird(int x, int y, double angle) {
		super(x, y, angle);
		centerx = x;
		centery = y;
		rotation = 0;
	}
	
	public void move(int x, int y){
		super.move(x, y);
		centerx+=x;
		centery+=y;
	}
	
	public void MouseMoved(int x, int y){
		rotation = getAngle(x,y);
	}
	
	private int getAngle(int x, int y){
		double ycomp = centery-y;
    	double xcomp = centerx-x;
    	double theta = Math.toDegrees((Math.atan(ycomp/xcomp)));
    	theta+=shipRotation;
    	if(xcomp<0)
    		theta+=180;
    	theta-=27;
    	return (int) theta;
	}
	
	public void MouseClicked(int x, int y){ }

	protected void base(Graphics g)
	{
		int imgheight = ImageStorage.getBird().getHeight(null);
		int imgwidth = ImageStorage.getBird().getWidth(null);
		
		Image tank;
		BufferedImage img = new BufferedImage(imgheight, imgwidth, BufferedImage.TYPE_INT_ARGB);
		tank = img;
		Graphics g2 = tank.getGraphics();
		g2.drawImage(ImageStorage.getBird(), 0, 0, null);
	
		ImageStorage.drawTank(g,tank,rotate(rotation,x-imgwidth/2,y-imgheight/2,imgwidth/2,imgheight/2));
	}
}
