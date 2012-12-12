import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.imageio.*;

public class ImageStorage 
{
	public Image AircraftCarrier;
	public Image BattleShip,BattleShipN,BattleShipE,BattleShipS;
	public Image Submarine;
	public Image Missile;
	public Image Bullet;
	public Image Jet;
	String s;

	public ImageStorage()
	{
		try{
			AircraftCarrier = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/AircraftCarrier/AircraftCarrier.png"));
			BattleShip = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/BattleShip/BattleShip.png"));
			Bullet = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/Other/Bullet.png"));
			Missile = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/Other/Missle.png"));
			Jet = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/Plane/Jet Fighter.png"));
			Submarine = ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/Submarine/Submarine.png"));
		}
		catch(Exception e){e.printStackTrace();}
	}

	public void drawAircraftCarrier(Graphics g, int x, int y){
		g.drawImage(AircraftCarrier,x,y,null);
	}

	public void drawBattleShip(Graphics2D g, AffineTransform at){
		//g.drawImage(BattleShip,x,y,null);
		g.drawImage(BattleShip, at, null);
	}

	public void drawSubmarine(Graphics g, int x, int y){
		g.drawImage(Submarine,x,y,null);
	}

	public void drawMissile(Graphics g, int x, int y){
		g.drawImage(Missile,x,y,null);
	}

	public void drawBullet(Graphics g, int x, int y){
		g.drawImage(Bullet,x,y,null);
	}

	public void drawJet(Graphics g, int x, int y){
		g.drawImage(Jet,x,y,null);
	}
}
