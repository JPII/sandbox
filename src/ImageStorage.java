import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.imageio.*;

public class ImageStorage 
{
	public static Image Tank;
	private static String s;

	public static void init()
	{
		try{
			s = "Tank/TankBase.png";
				Tank = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/" + s));
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public static void drawTank(Graphics g,Image tank,AffineTransform at){
		((Graphics2D)g).drawImage(tank,at,null);
	}
	
	public static Image getTank(){
		return Tank;
	}
}
