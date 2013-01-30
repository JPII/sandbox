import java.awt.*;
import java.util.ArrayList;

public class Submarine extends Ship{
	
	private ArrayList<Missle> bullets;
	private ImageStorage is;
	private boolean moving;
	
	public Submarine(int x,int y,int color,double angle){
		super(x,y,color,angle);
		bullets = new ArrayList<Missle>();
		is = new ImageStorage();
	}
	
	public boolean needsRepaint(){
		if (moving)
			return true;
		for(int index = 0; index<bullets.size();index++){
			if(bullets.get(index).needsRepaint()){
				return true;
			}
		}
		return false;
	}
	
	public void MouseMoved(int x, int y){
		for(int index = 0; index<bullets.size(); index++){
			bullets.get(index).MouseMoved(x,y);
		}
	}
	public void MouseClicked(int x, int y){
		bullets.add(new Missle(this.x,this.y+25,x,y));
	}
	
	protected void base(Graphics g,int size)
	{	
		//x and y are the center of the ship
		int halfcellwidth = 25;
		int imgheight = is.BattleShip.getHeight(null);
		is.drawSubmarine((Graphics2D)g, rotate(angle,x,y,halfcellwidth,imgheight/2));
		
		for(int index=0; index<bullets.size(); index++){
			bullets.get(index).drawBullet(g);
		}
		for(int index=0; index<bullets.size(); index++){
			if(bullets.get(index).isdone()){
				bullets.remove(index);
				moving = true;
			}
		}
	}
}
