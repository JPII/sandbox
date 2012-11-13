import java.awt.*;
import java.util.*;


public class Bullet {
	private double startx;
	private double endx;
	private double starty;
	private double endy;
	private int currentx;
	private int currenty;
	private int count;
	
	private boolean moving;
	private boolean done;
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private ArrayList particle;
	
	public Bullet(int sx,int sy,int ex, int ey){
		startx = sx;
		starty = sy;
		endx = ex;
		endy = ey;
		currentx=(int)startx-1;
		currenty=(int)starty-1;
		count = 0;
		moving =false;
	}
	
	public boolean needsRepaint(){
		if(moving)
			return true;
		return false;
	}
	
	private void increaseX(int ammount){
		double xdistance = endx-startx;
		double ydistance = endy-starty;
		double theta = Math.atan(ydistance/xdistance);
		if(xdistance < 0 ){
			theta+=Math.PI;
		}
		double x = (count)*Math.cos(theta);
		double y = (count)*Math.sin(theta);
		currentx=(int)(x+startx);
		currenty=(int)(y+starty);
		count+=2;
	}
	
	public void drawBullet(Graphics g){
		if(endx < currentx)
			increaseX(-1);
		if(endx>currentx)
			increaseX(1);
		drawBull(g);
		if(isnearX()){
			moving=true;
		}
		else {
			done = true;
			moving = false;
		}
	}
	public void drawBull(Graphics g){
		g.setColor(Color.gray);
		g.fillOval(currentx-2, currenty-2, 5, 5);
	}
	
	private boolean isnearX(){
		if(currentx<(int)endx+2 && currentx > (int)endx-2){
			return false;
		}
		return true;
	}
	
	public boolean isdone(){
		return done;
	}
	public boolean getMoving(){
		return moving;
	}
}
