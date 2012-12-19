import java.awt.*;


public class Missle extends BaseBullet{
	
	private int distance;
	
	public Missle(int sx, int sy, int clickx, int clicky, BaseTank fired) {
		super(sx, sy, clickx, clicky, fired);
	}
	
	public void MouseMoved(int x, int y){
		startx = currentx;
		starty = currenty;
		count = 4;
	}
	
	protected void increaseX(int ammount){
		super.increaseX(ammount);
		count+=2;
		distance+=4;
	}
	
	public void drawBullet(Graphics g){
		super.drawBullet(g);
		if(distance>2000){
			finished();
		}
	}
	
	public void drawBull(Graphics g){
		g.setColor(Color.green);
		g.fillOval(currentx-2,currenty-2,10,5);
		g.fillRect(currentx-5,currenty-2,10,5);
	}
	
	protected boolean isnearX(){
		return true;
	}
}
