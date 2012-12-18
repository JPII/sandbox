import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class BaseTank {
	
	protected int x,y;
	protected boolean moving;
	protected int color;
	protected double angle;
	
	protected Rectangle command;
	
	public BaseTank(int x, int y,int color,double angle){
		this.x=x;
		this.y=y;
		this.color=color;
		this.angle=angle;
		command = new Rectangle(x,y,50,50);
	}
	public void move(int x,int y){
		if(x!=0){
			angle = 90+(Math.toDegrees(Math.atan(y/x)));
		if(x<0)
			angle+=180;
		}
		else{
			angle = 90+Math.toDegrees(Math.asin(y));
		}
		this.x+=x;
		this.y+=y;
	}
	protected void addAngle(int angle){
		this.angle+=angle;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public double getAngle(){
		return angle;
	}
	abstract public void MouseMoved(int x, int y);
	abstract public void MouseClicked(int x, int y);
	public boolean needsRepaint(){
		if(moving){
			return true;
		}
		return false;
	}
	public void drawShip(Graphics g){
		base(g);
	}	
	abstract protected void base(Graphics g);
	
	protected Color getColor(){
		switch(color){
			case 1: return Color.blue;
			case 2: return Color.red;
			case 3: return Color.cyan;
			case 4: return Color.yellow;
			case 5: return Color.orange;
			case 6: return Color.green;
			
			default: return null;
		}
	}
	
	public AffineTransform rotate(double angle, double distancex, double distancey,int imgwidth,int imgheight) {
		AffineTransform aff = new AffineTransform();
		aff.translate(distancex+imgwidth,distancey+imgheight);
		aff.rotate(angle / 57.29577);
		aff.translate(-imgwidth,-imgheight);
		return aff;
	}
}
