import java.awt.*;

public class Submarine {

	private int x,y;
	
	public final int NORTH = 0;
	public final int SOUTH = 180;
	public final int EAST = 270;
	public final int WEST = 90;
	
	private int color;
	
	public Submarine(int x, int y,int color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void drawShip(Graphics g){
		base(g);
	}
	
	private void base(Graphics g)
	{	
		//x and y are the center of the ship
		
		//Body
		g.setColor(Color.gray.brighter());
		g.fillOval(x, y, 25, 115);
		g.setColor(Color.black);
		g.drawOval(x, y, 25, 115);	
				
		//Command Center
		g.setColor(getColor().darker().darker());
		g.fillOval(x+5, y+40, 15, 15);
		g.setColor(getColor().darker());
		g.fillRect(x, y+46, 25, 3);
	}
	
	private Color getColor(){
		switch(color){
			case 1: return Color.green;
			case 2: return Color.red;
			default: return null;
		}
	}
}
