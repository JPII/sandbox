package com.com.com.com.com.com.com.com.thiis.is.maxs.only;

public class $$$$$$$$$$$$$$$$$$$$ {
	private static int width = 50, height = 50;
	static {
		$();
	}
	private static void $() {
		
	}
	public static void $_00(int width1, int height1) {
		width = width1;
		height = height1;
	}
	public static float $(float cx, float cz) {
		if (cx <= 0 || cz <= 0 || cx >= width || cz >= height) {
			return 0.0f;
		}
		else if (cx <= 30 && (cz >= 30 && cz <= height-30)) {
			return $$$$$(0,ProceduralLayeredMapGenerator.getPoint(cx, cz),cx/30.0f);
		}
		else if (cz <= 30 && (cx >= 30 && cx <= width-30)) {
			return $$$$$(0,ProceduralLayeredMapGenerator.getPoint(cx, cz),cz/30.0f);
		}
		else if (cx >= width-30 && (cz >= 30 && cz <= height-30)) {
			return $$$$$(0,ProceduralLayeredMapGenerator.getPoint(cx, cz),(width-cx)/30.0f);
		}
		else if (cz >= height-30 && (cx >= 30 && cx <= width-30)) {
			return $$$$$(0,ProceduralLayeredMapGenerator.getPoint(cx, cz),(height-cz)/30.0f);
		}
		else if (!(cz >= 30 && cz <= height-30) || !(cx >= 30 && cx <= width-30))
			return 0.0f;
		else {
			return ProceduralLayeredMapGenerator.getPoint(cx, cz);
		}
	}
	public static float $$$$$(float num0, float num1, float amount)
    {
    	return num0 + (amount*(num1-num0));
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

