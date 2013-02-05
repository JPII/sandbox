package com.com.com.com.com.com.com.com.thiis.is.maxs.only;

import java.awt.Point;

public class $$$$$$$$$$$$$$$$$$$$ {
	private static int width = 50, height = 50;
	private static $4[] set;
	private static long seed = (long)(Math.random() * Long.MAX_VALUE);
	private static Rand rand = new Rand(seed);
	static {
		$();
	}
	private static void $() {
		
	}
	public static void $_00(int width1, int height1) {
		width = width1;
		height = height1;
		set = new $4[rand.nextInt(25,35)];
		Point near = new Point(rand.nextInt(50,width-50),rand.nextInt(50,height-50));
		near.x = (near.x+width)/3;
		near.y = (near.y+height)/3;
		for (int s = 0; s < set.length; s++) {
			set[s] = new $4(new Point(near.x+rand.nextInt(-20,20),near.y+rand.nextInt(-20,20)), rand.nextInt(5,15));
		}
	}
	public static float $(float cx, float cz) {
		float f = 0.0f;
		int count = 0;
		for (int c = 0; c < set.length; c++) {
			float radius = set[c].radius;
			Point p = set[c].point;
			float dist = (float)Math.sqrt(Math.pow(p.x - cx,2)+Math.pow(p.y - cz,2));
			if (dist <= radius) {
				f += ($$$$$(1.0f,0.2f,dist/radius)/4);
				count++;
			}
		}
		if (count-1 > 0) {
		//	f = f/(count-1);
		}
		return ((f*1.75f) + ProceduralLayeredMapGenerator.getPoint(cx/4, cz/4))/3;
	}
	public static float $$$$$(float num0, float num1, float amount)
    {
    	return num0 + (amount*(num1-num0));
    }
}

class $4 {
	public Point point;
	public int radius;
	public $4(Point p, int rad) {
		point = p;
		radius = rad;
	}
}
class ProceduralLayeredMapGenerator {
	static Berlin berlin;

	static {
		doInit();
	}
	private static void doInit() {
		berlin = new Berlin((long)(Math.random() * Long.MAX_VALUE));
	}
	public static float getPoint(float x, float z) {
		x /= 2;
		z /= 2;
		float lvl0 = getLevel0(x,z);
		//float lvl1 = getLevel1(x,z);
		float lvl2 = getLevel2(x,z);
		float lvl3 = getLevel3(x,z);
		float lvl4 = getLevel4(x,z);
		//float lvl5 = getLevel5(x,z);
		//float lvl6 = getLevel6(x,z);
		//float lvl7 = getLevel7(x,z);
		float mixer = ((lvl0*25.0f)+(lvl4*5)+(lvl2*2.5f)+(lvl3*2.5f)) / 38.0f;//(lvl1*20.0f)+(lvl2*5.0f)+(lvl3*3.0f)+
				//(lvl4*5.0f)+(lvl5*5.0f)+(lvl6*1.5f)-(lvl7*12.0f))/98.5f;
		float mixed = ((mixer+1)/2.0f)-0.1f;
		
		if (mixed > 0.57)
			mixed += 0.28;
		
		/*if (blitRiver(x,z)){
			mixed = getLevel2(mixer,mixed+z)+0.2f;
			//if (mixed < 0.0f)
				mixed = 0;
			//if (mixed > 0.4f)
				//mixed = 0.4f;
		}*/
		
		float res = (float) ((mixed - 0.3)/0.21);
		res -= 0.3f;
		if (res > 1)
			res = 1;
		if (res < 0)
			res = 0;
		
		return res;
	}
	private static float ld0 = 1024;
	private static float ld1 = 128;
	private static float ld2 = 32;
	private static float ld3 = 64;
	private static float ld4 = 512;
	private static float ld5 = 1024;
	private static float ld7 = 8196;
	private static float getLevel7(float x, float z) {
		return berlin.noise(x/ld7,z/ld7);
	}
	private static float getLevel0(float x, float z) {
		return berlin.noise(x/ld0, z/ld0);
	}
	private static float getLevel6(float x, float z) {
		return berlin.noise(x,z);
	}
	private static float getLevel1(float x, float z) {
		return berlin.noise(x/ld1,z/ld1);
	}
	private static float getLevel2(float x, float z) {
		return berlin.noise(x/ld2,z/ld2);
	}
	private static float getLevel3(float x, float z) {
		return berlin.noise(x/ld3,z/ld3);
	}
	private static float getLevel4(float x, float z) {
		return berlin.noise(x/ld4,z/ld4);
	}
	private static float getLevel5(float x, float z) {
		return berlin.noise(x/ld5,z/ld5);
	}
}

