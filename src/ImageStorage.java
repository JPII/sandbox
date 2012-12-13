import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.imageio.*;

public class ImageStorage 
{
	public Image AircraftCarrier;
	public Image BattleShip;
	public Image Submarine;
	public Image Jet;
	String s;

	public ImageStorage()
	{
		try{
			s = "AircraftCarrier/AircraftCarrier.png";
				AircraftCarrier = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/" + s));
			s = "BattleShip/BattleShip.png";
				BattleShip = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/" + s));
			s = "Plane/Jet Fighter.png";
				Jet = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/" + s));
			s = "Submarine/Submarine.png";
				Submarine = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/" + s));
		}
		catch(Exception e){e.printStackTrace();}
	}

	public void drawAircraftCarrier(Graphics2D g, AffineTransform at){
		g.drawImage(AircraftCarrier,at,null);
	}

	public void drawBattleShip(Graphics2D g, AffineTransform at){
		g.drawImage(BattleShip,at,null);
	}

	public void drawSubmarine(Graphics2D g, AffineTransform at){
		g.drawImage(Submarine,at,null);
	}

	public void drawJet(Graphics g, int x, int y){
		g.drawImage(Jet,x,y,null);
	}
}
