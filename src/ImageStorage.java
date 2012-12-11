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
	String name,name1,name2,name3,name4,name5;
	
	public ImageStorage()
	{
		try{
		name = "AircraftCarrier/AircraftCarrier.png";
		AircraftCarrier = 
			ImageIO.read(ImageStorage.class.getResource("../../../../NavalBattle/src/com/jpii/navalbattle/res/drawable-game"+name));
		name1 = "BattleShip/BattleShip.png";
		BattleShip = 
			ImageIO.read(ImageStorage.class.getResource("../../../../NavalBattle/src/com/jpii/navalbattle/res/drawable-game"+name));
		name2 = "Other/Bullet.png";
		Bullet = 
			ImageIO.read(ImageStorage.class.getResource("../../../../NavalBattle/src/com/jpii/navalbattle/res/drawable-game"+name));
		name3 = "Other/Missle.png";
		Missile = 
			ImageIO.read(ImageStorage.class.getResource("../../../../NavalBattle/src/com/jpii/navalbattle/res/drawable-game"+name));
		name4 = "Plane/Jet Fighter.png";
		Jet = 
			ImageIO.read(ImageStorage.class.getResource("../../../../NavalBattle/src/com/jpii/navalbattle/res/drawable-game"+name));
		name5 = "Submarine/Submarine.png";
		Submarine = 
			ImageIO.read(ImageStorage.class.getResource("../../../../NavalBattle/src/com/jpii/navalbattle/res/drawable-game"+name));
		}
		catch(Exception e){}
	}
	
	public void drawAircraftCarrier(Graphics g, int x, int y){
		g.drawImage(AircraftCarrier,x,y,300,50,null);
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
