import java.awt.*;
import java.awt.image.BufferedImage;


public class Bird extends BaseTank{
	
	public Bird(int x, int y, double angle) {
		super(x, y, angle);
	}
	
	public void MouseMoved(int x, int y){
		
	}
	public void MouseClicked(int x, int y){ }

	protected void base(Graphics g)
	{
		int halfcellwidth = 25;
		int imgheight = ImageStorage.getBird().getHeight(null);
		int imgwidth = ImageStorage.getBird().getWidth(null);
		
		Image tank;
		BufferedImage img = new BufferedImage(imgheight, imgwidth, BufferedImage.TYPE_INT_RGB);
		tank = img;
		Graphics g2 = tank.getGraphics();
		g2.drawImage(ImageStorage.getBird(), 0, 0, null);
		
		ImageStorage.drawTank(g,tank,rotate(angle,x,y,halfcellwidth,imgheight/2));
	}
}
