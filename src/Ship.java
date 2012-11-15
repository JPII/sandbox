import java.awt.*;

public abstract class Ship {
	
	protected int x,y;
	protected int size;
	protected boolean moving;
	protected int color;
	
	public final int NORTH = 0;
	public final int SOUTH = 180;
	public final int EAST = 270;
	public final int WEST = 90;
	
	public Ship(int x, int y,int color){
		this.x=x;
		this.y=y;
		size = 15;
		this.color=color;
	}
	public void addX(int x){
		this.x+=x;
	}
	public void addY(int y){
		this.y+=y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
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
		base(g,size);
		g.setColor(Color.blue);
		g.fillRect(x, y,1,1);
	}	
	abstract protected void base(Graphics g,int size);
	
	protected Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
