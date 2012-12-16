import java.awt.*;


public class Tank extends BattleShip{

	public Tank(int x, int y, int color, double angle) {
		super(x, y, color, angle);
	}
	
	protected void initArray(){
		guns.add(new Turret(x+25,y+25,270,0,20,WEST));
	}
	
	protected void base(Graphics g, int size)
	{
		int halfcellwidth = 25;
		int imgheight = is.getTank().getHeight(null);
		int imgwidth = is.getTank().getWidth(null);
		g.setColor(Color.blue);
		g.fillRect(x, y, imgwidth, imgheight);
		((Graphics2D)g).drawImage(is.getTank(),rotate(angle,x,y,halfcellwidth,imgheight/2),null);
	}
}
