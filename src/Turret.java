import java.awt.Color;
import java.awt.Graphics;


public class Turret {
	private int centerx;
	private int centery;
	private int rotation;
	private int shipRotation;
	private int maxRotation;
	@SuppressWarnings("unused")
	private int minRotation;
	private int size;
	private int gunSize;
	private int desrotation;
	
	public Turret() {}
	
	public Turret(int x, int y, int max, int min, int size, int shipRotation){
		centerx = x;
		centery = y;
		maxRotation = max;
		minRotation = min;
		rotation = 0;
		this.shipRotation = shipRotation;
		this.size = size;
		gunSize = 4;
	}
	
	public void giveXandY(int x, int y){
		rotation = getAngle(x,y);
	}
	public void addX(int x){
		centerx+=x;
	}
	public void addY(int y){
		centery+=y;
	}
	
	private int getAngle(int x, int y){
		double ycomp = centery-y;
    	double xcomp = centerx-x;
    	double theta = Math.toDegrees((Math.atan(ycomp/xcomp)));
    	theta+=shipRotation;
    	if(xcomp<0)
    		theta+=180;
    	return (int) theta;
	}
	
	@SuppressWarnings("unused")
	private void snapTurret(){
		if(desrotation<0){
			desrotation +=360;
		}
		desrotation%=360;
		if(desrotation>maxRotation){
			int temp = 360-maxRotation;
			if(desrotation<=maxRotation +temp/2)
				desrotation = maxRotation;
			else
				desrotation = 0;
		}
	}
	
	private int getCos(int size,int gunRotation){
		return (int) (size*Math.cos(Math.toRadians(gunRotation)));
	}
	private int getSin(int size, int gunRotation){
		return (int) (size*Math.sin(Math.toRadians(gunRotation)));
	}
	
	public void drawGun(Graphics g) {
		int cvalue = getCos(size,rotation);
		int svalue = getSin(size,rotation);		 
		int yoffset = (cvalue+svalue)/2;
		int offset = -1*(cvalue-svalue)/2;
		
		g.setColor(Color.gray.darker());
		int xarray[] = {centerx-offset,centerx+svalue-offset,centerx+svalue-cvalue-offset,centerx-cvalue-offset};
		int yarray[] = {centery+yoffset,centery-cvalue+yoffset,centery-cvalue-svalue+yoffset,centery-svalue+yoffset};
		g.fillPolygon(xarray,yarray,4);
		
		g.setColor(Color.black);		
		int xarray2[] = {xarray[0]-getCos(size/3,rotation),xarray[0]-getCos(size/3-size/6,rotation),xarray[0]-getSin(size-size/gunSize,rotation)-getCos(size/3-size/6,rotation),xarray[0]-getSin(size-size/gunSize,rotation)-getCos(size/3,rotation)};
		int yarray2[] = {yarray[0]-getSin(size/3,rotation),yarray[0]-getSin(size/3-size/6,rotation),yarray[0]+getCos(size-size/gunSize,rotation)-getSin(size/3-size/6,rotation),yarray[0]+getCos(size-size/gunSize,rotation)-getSin(size/3,rotation)};
		g.fillPolygon(xarray2,yarray2,4);
		
		int xarray3[] = {xarray[3]+getCos(size/3,rotation),xarray[3]+getCos(size/3-size/6,rotation),xarray[3]-getSin(size-size/gunSize,rotation)+getCos(size/3-size/6,rotation),xarray[3]-getSin(size-size/gunSize,rotation)+getCos(size/3,rotation)};
		int yarray3[] = {yarray[3]+getSin(size/3,rotation),yarray[3]+getSin(size/3-size/6,rotation),yarray[3]+getCos(size-size/gunSize,rotation)+getSin(size/3-size/6,rotation),yarray[3]+getCos(size-size/gunSize,rotation)+getSin(size/3,rotation)};
		g.fillPolygon(xarray3,yarray3,4);		
	}
}
