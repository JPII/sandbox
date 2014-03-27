import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public abstract class BaseTank {
	
	protected int x,y;
	protected boolean moving;
	protected double angle;
	
	public Rectangle rectangle;
	
	public BaseTank(int x, int y,double angle){
		this.x=x;
		this.y=y;
		this.angle=angle;
		rectangle = new Rectangle(x,y,ImageStorage.getBird().getWidth(null),ImageStorage.getBird().getHeight(null));
	}
	public void move(int x,int y){
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
	
	public void checkPhysics(){
		ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
		rects.add(rectangle);
	}
	
	public AffineTransform rotate(double angle, double distancex, double distancey,int imgwidth,int imgheight) {
		AffineTransform aff = new AffineTransform();
		aff.translate(distancex+imgwidth,distancey+imgheight);
		aff.rotate(angle / 57.29577);
		aff.translate(-imgwidth,-imgheight);
		return aff;
	}
}
