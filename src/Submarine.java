import java.awt.*;

public class Submarine {

	private int centerx, centery;
	
	public final int NORTH = 0;
	public final int SOUTH = 180;
	public final int EAST = 270;
	public final int WEST = 90;
	
	private int color;
	
	public Submarine(int x, int y,int color){
		centerx=x;
		centery=y;
		this.color=color;
	}
	
	public int getX(){
		return centerx;
	}
	public int getY(){
		return centery;
	}
	public void addX(int x){
		centerx += x;
	}
	public void addY(int y){
		centery += y;
	}

	public void drawShip(Graphics g){
		base(g);
	}
	
	private void base(Graphics g)
	{	
		//x and y are the center of the ship
		
		//Body
		g.setColor(Color.gray.brighter());
		g.fillOval(centerx, centery, 25, 115);
		g.setColor(Color.black);
		g.drawOval(centerx, centery, 25, 115);	
				
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillOval(centerx+5, centery+40, 15, 15);
		g.setColor(getColor().darker());
		g.fillRect(centerx, centery+46, 25, 3);
	}
	
	private Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
