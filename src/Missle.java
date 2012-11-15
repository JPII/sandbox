import java.awt.Graphics;


public class Missle extends Bullet{

	public Missle(int sx, int sy, int ex, int ey) {
		super(sx, sy, ex, ey);
	}
	
	public void MouseMoved(int x, int y){
		endx = x;
		endy = y;
	}
}
