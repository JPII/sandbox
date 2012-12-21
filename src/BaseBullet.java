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
	
	protected int numBounces;
	protected int bounced;
	
	public BaseBullet(int sx,int sy,int clickx, int clicky,BaseTank fired){
		this.fired = fired;
		startx = sx;
		starty = sy;
		currentx=(int)startx-1;
		currenty=(int)starty-1;
		count = 0;
		moving =false;
		bounced = numBounces = 0;
		
		if(clickx-startx!=0)
		theta = (Math.atan(((starty-clicky)/(clickx-startx))));
		else
			theta = Math.asin(clicky-starty);
		if(clickx-startx < 0 ){
			theta+=Math.PI;
		}
		if(theta<0)
			theta+=Math.PI*2;
	}
	
	public boolean needsRepaint(){
		if(moving)
			return true;
		return false;
	}
	
	protected void increaseX(int ammount){
		double x = (count)*Math.cos((theta));
		double y = (count)*Math.sin((theta));
		currentx=(int)(startx+x);
		currenty=(int)(starty-y);
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
	
	protected void drawBull(Graphics g){
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
	
	public Point getPoint(){
		return new Point(currentx,currenty);
	}
	
	public void bounce(int t,Rectangle r) {
		if(bounced<numBounces && r!=null){
			findFace(r);
			//this.theta += 180;
			bounced++;
			startx = currentx;
			starty = currenty;
			count=4;
			
		}
		else{
			BulletManager.remove(t);
		}
	}
	
	private int findFace(Rectangle r){
		double theta = this.theta*180/Math.PI;
		int south = Math.abs(currenty - r.y);
		int west = Math.abs(currentx - r.x);
		int east = Math.abs((r.x+r.width - currentx));
		int north = Math.abs((r.y+r.height - currenty));
		int temp = north;
		if(west < temp) {
			temp = west;
			currentx = r.x -1;
			this.theta = Math.PI*(180-theta)/180;
		}
		if(south < temp){
			temp = south;
			currenty = r.y -1;
			this.theta = Math.PI*(360-theta)/180;
		}
		if(east < temp){
			temp = east;
			currentx = r.x+r.width +1;
			this.theta = Math.PI*(180-theta)/180;
		}
		
		if(temp == east)
			temp = 2;
		if(temp == north){
			temp = 1;
			currenty = r.y+r.height +1;
			this.theta = Math.PI*(360-theta)/180;
		}
		if(temp == west)
			temp = 0;
		if(temp == south)
			temp = 3;
		
		return temp;
	}
}
