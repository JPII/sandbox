import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.imageio.*;

public class ImageStorage 
{
	public static Image Bird, Sand;
	private static String s;

	public static void init()
	{
		try{
			s = "Bird/Bird.gif";
				Bird = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/" + s));
			s = "Tank/sand3.jpg";
				Sand = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/" + s));
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public static void drawTank(Graphics g,Image tank,AffineTransform at){
		((Graphics2D)g).drawImage(tank,at,null);
	}
	
	public static Image getBird(){
		return Bird;
	}
	
	public static Image getSand(){
		return Sand;
	}
}
