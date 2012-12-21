import java.awt.*;
import java.util.ArrayList;


public class Barrier {
	public static ArrayList<Rectangle> barriers;
	
	public static void init(int width, int height){
		barriers = new ArrayList<Rectangle>();
		barriers.add(new Rectangle(0,0,10,height));
		barriers.add(new Rectangle(0,0,width,10));
		barriers.add(new Rectangle(width-10-6,0,10,height));
		barriers.add(new Rectangle(0,height-10-28,width,10));
	}
	
	public static void drawBarriers(Graphics g){
		for(int index = 0; index<barriers.size(); index++){
			g.setColor(Color.green);
			fillRectangle(g,barriers.get(index));
		}
	}
	
	private static void fillRectangle(Graphics g, Rectangle r){
		g.fillRect(r.x, r.y, r.width, r.height);
	}
	
	public static void checkPhysics(){
		ArrayList<Integer> temp = BulletManager.isInside(barriers);
		if(!temp.isEmpty()){
			BulletManager.bounce(temp,getInside(temp.get(0)));
		}
	}
	
	private static Rectangle getInside(int t){
		Point temp = BulletManager.bullets.get(t).getPoint();
		for(int index = 0; index<barriers.size(); index++){
			if(barriers.get(index).contains(temp))
				return barriers.get(index);
		}
		return null;
	}
}
