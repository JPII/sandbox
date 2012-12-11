import java.awt.*;

import javax.imageio.*;

public class ImageStorage 
{
	public Image AircraftCarrier;
	public Image BattleShip;
	public Image Submarine;
	public Image Missile;
	public Image Bullet;
	public Image Jet;
	String s;
	
	public ImageStorage()
	{
		try{
		s = "AircraftCarrier/AircraftCarrier.png";
		AircraftCarrier = 
				ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/"+s));
		s = "BattleShip/BattleShip.png";
		BattleShip = 
				ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/"+s));
		s = "Other/Bullet.png";
		Bullet = 
				ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/"+s));
		s = "Other/Missle.png";
		Missile = 
				ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/"+s));
		s = "Plane/Jet Fighter.png";
		Jet = 
				ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/"+s));
		s = "Submarine/Submarine.png";
		Submarine = 
				ImageIO.read(ImageStorage.class.getResource("/com/jpii/navalbattle/res/drawable-game/"+s));
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public void drawAircraftCarrier(Graphics g, int x, int y){
		g.drawImage(AircraftCarrier,x,y,null);
	}
	
	public void drawBattleShip(Graphics g, int x, int y){
		g.drawImage(BattleShip,x,y,null);
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
