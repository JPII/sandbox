import java.awt.*;
import java.util.*;

public class BulletManager {
	public static ArrayList<BaseBullet> bullets;
	
	public static void init(){
		bullets = new ArrayList<BaseBullet>();
	}
	
	public static int getNumOwn(BaseTank t){
		int count=0;
		for(int index=0; index<bullets.size(); index++){
			if(bullets.get(index).fired.equals(t))
				count++;
		}
		return count;
	}

	public static void add(BaseBullet baseBullet) {
		bullets.add(baseBullet);
	}
	
	public static void act(Graphics g){
		for(int index=0; index<bullets.size(); index++){
			bullets.get(index).drawBullet(g);
		}
	}
	
	public static ArrayList<Integer> isInside(ArrayList<Rectangle> t){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int index=0; index<bullets.size(); index++){
			for(int count = 0; count<t.size(); count++)
			{
				if(t.get(count).contains(bullets.get(index).getPoint()) && !bullets.get(index).fired.rectangle.equals(t.get(count))){
					temp.add(index);
					break;
				}
			}
		}
		return temp;
	}
	
	public static void remove(ArrayList<Integer> t){
		int count = 0;
		for(int index = 0; index<t.size(); count++){
			bullets.remove(t.get(index)-count);
			t.remove(index);
		}
	}
	
	public static void remove(int t){
		bullets.remove(t);
	}
	
	public static void bounce(ArrayList<Integer> t,Rectangle r){
		for(int index = 0; index<t.size(); index++){
			if(t.get(index)<bullets.size())
				bullets.get(t.get(index)).bounce(t.get(index).intValue(),r);
		}
	}
}
