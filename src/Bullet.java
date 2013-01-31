import BaseBullet;
import BaseTank;


public class Bullet extends BaseBullet{
	
	public Bullet(int sx, int sy, int clickx, int clicky, BaseTank fired) {
		super(sx, sy, clickx, clicky, fired);
		numBounces = 1;
	}
}
