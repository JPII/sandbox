import java.awt.*;


public class Missle extends Bullet{
	
	private int distance;
	
	public Missle(int sx, int sy, int ex, int ey) {
		super(sx, sy, ex, ey);
	}
	
	public void MouseMoved(int x, int y){
		startx = currentx;
		starty = currenty;
		endx = x;
		endy = y;
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
		g.setColor(new Color(0,255,0,50));
		g.fillOval(currentx-2,currenty-2,10,5);
		g.fillRect(currentx-2,currenty-2,10,5);
	}
	
	protected boolean isnearX(){
		if(currentx<(int)endx+4 && currentx > (int)endx-4){
			if(currenty<(int)endy+4 && currenty > (int)endy-4){
				return false;
			}
		}
		return true;
	}
}
