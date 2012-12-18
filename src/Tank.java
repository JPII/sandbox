import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Tank extends BaseTank{
	
	protected ArrayList<Turret> guns;
	
	public Tank(int x, int y, int color, double angle) {
		super(x, y, color, angle);
		guns = new ArrayList<Turret>();
		initArray();
	}
	
	protected void initArray(){
		guns.add(new Turret(x+25,y+25,getColor(),20,0));
	}
	
	public void move(int x,int y){
		super.move(x,y);		
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).move(x,y);
		}
	}
	public void MouseMoved(int x, int y){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).MouseMoved(x,y);
		}
	}
	public void MouseClicked(int x, int y){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).MouseClicked(x,y);
		}
	}
	public boolean needsRepaint(){
		if(super.needsRepaint()){
			return true;
		}
		for(int index = 0; index<guns.size();index++){
			if(guns.get(index).needsRepaint()){
				return true;
			}
		}
		return false;
	}
	public void drawShip(Graphics g){
		super.drawShip(g);
		drawGuns(g);
	}
	
	private void drawGuns(Graphics g){
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).drawGun(g);
		}
	}
	/////////////////////////////////////////////////////////////////
	protected void addAngle(int theta){
		super.addAngle(theta);
		int halfcellwidth = 25;
		int imgheight =100;
		for(int index = 0; index<guns.size(); index++){
			guns.get(index).shipRotated(angle,x+halfcellwidth,y+imgheight/2);
		}
	}
	protected void base(Graphics g)
	{
		int halfcellwidth = 25;
		int imgheight = ImageStorage.getTank().getHeight(null);
		int imgwidth = ImageStorage.getTank().getWidth(null);
		
		Image tank;
		BufferedImage img = new BufferedImage(imgheight, imgwidth, BufferedImage.TYPE_INT_RGB);
		tank = img;
		Graphics g2 = tank.getGraphics();
		g2.setColor(getColor());
		g2.fillRect(0, 0, imgwidth, imgheight);
		g2.drawImage(ImageStorage.getTank(), 0, 0, null);
		
		ImageStorage.drawTank(g,tank,rotate(angle,x,y,halfcellwidth,imgheight/2));
	}
}
