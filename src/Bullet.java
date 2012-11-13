import java.awt.*;
import java.util.*;


public class Bullet {
	private double startx;
	private double endx;
	private double starty;
	private double endy;
	private double slope;
	private int currentx;
	
	private boolean moving;
	private boolean done;
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private ArrayList particle;
	
	public Bullet(int sx,int sy,int ex, int ey){
		startx = sx;
		starty = sy;
		endx = ex;
		endy = ey;
		slope = slope();
		currentx=(int)startx-1;
		moving =false;
	}
	
	public boolean needsRepaint(){
		if(moving)
			return true;
		return false;
	}
	
	private double slope(){
		return ((endy-starty)/(endx-startx));
	}
	
	private double getY(double x){
		slope = slope();
		return (slope * x + starty); 
	}
	
	public void drawBullet(Graphics g){
		if(endx < currentx)
			currentx--;
		if(endx>currentx)
			currentx++;
		g.setColor(Color.gray);
		g.fillRect((int)(currentx)-2, (int)(getY(currentx-startx)-2), 5, 5);
		if((int)currentx!=(int)endx){
			moving=true;
		}
		else {
			done = true;
			moving = false;
		}
	}
	
	public boolean isdone(){
		return done;
	}
	
	public boolean getMoving(){
		return moving;
	}
}
