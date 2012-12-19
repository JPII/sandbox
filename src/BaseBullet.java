import java.awt.*;

public class BaseBullet {
	protected double startx;
	protected double starty;
	
	protected int currentx;
	protected int currenty;
	protected int count;
	
	protected double theta;
	
	protected BaseTank fired;
	protected boolean moving;
	protected boolean done;
	
	public BaseBullet(int sx,int sy,int clickx, int clicky,BaseTank fired){
		this.fired = fired;
		startx = sx;
		starty = sy;
		currentx=(int)startx-1;
		currenty=(int)starty-1;
		count = 0;
		moving =false;
		
		if(clickx-startx!=0)
		theta = Math.atan((clicky-starty)/(clickx-startx));
		else
			theta = Math.asin(clicky-starty);
		if(clickx-startx < 0 ){
			theta+=Math.PI;
		}
	}
	
	public boolean needsRepaint(){
		if(moving)
			return true;
		return false;
	}
	
	protected void increaseX(int ammount){
		double x = (count)*Math.cos(theta);
		double y = (count)*Math.sin(theta);
		currentx=(int)(x+startx);
		currenty=(int)(y+starty);
		count+=4;
	}
	
	public void drawBullet(Graphics g){
		increaseX(1);
		g.setColor(new Color(150,0,150,150));
		drawBull(g);
		if(isnearX()){
			moving=true;
		}
		else {
			finished();
		}
	}
	protected void finished(){
		done = true;
		moving = false;
	}
	
	public void drawBull(Graphics g){
		g.fillOval(currentx-2, currenty-2, 7, 3);
	}
	
	protected boolean isnearX(){
		return true;
	}
	
	public boolean isdone(){
		return done;
	}
	public boolean getMoving(){
		return moving;
	}
}
