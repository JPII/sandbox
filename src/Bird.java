import java.awt.*;
import java.awt.image.BufferedImage;


public class Bird extends BaseTank{
	
	public Bird(int x, int y, double angle) {
		super(x, y, angle);
	}
	
	public void MouseMoved(int x, int y){
		angle+=2;
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
		
		ImageStorage.drawTank(g,tank,rotate(angle,x,y,imgwidth/2,imgheight/2));
	}
}
