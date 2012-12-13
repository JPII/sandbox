import java.util.*;
import java.awt.*;


public class Turret {
	private double centerx;
	private double centery;
	private int rotation;
	private int shipRotation;
	private int maxRotation;
	private int size;
	private int gunSize;
	private int desrotation;
	
	private boolean moving;
	
	private ArrayList<Bullet> bullets;
	
	public Turret() {}
	public Turret(int x, int y, int max, int min, int size, int shipRotation){
		centerx = x;
		centery = y;
		maxRotation = max;
		rotation = 0;
		this.shipRotation = shipRotation;
		this.size = size;
		gunSize = 4;
		bullets = new ArrayList<Bullet>();
		moving = false;
	}
	
	public void MouseMoved(int x, int y){
		rotation = getAngle(x,y);
	}
	public void MouseClicked(int x, int y){
		fireGun(x,y);
	}
	public void addX(int x){
		centerx+=x;
	}
	public void addY(int y){
		centery+=y;
	}
	public void addSize(int s){
		size+=s;
	}
	public boolean needsRepaint(){
		if (moving)
			return true;
		for(int index=0; index<bullets.size(); index++){
			if(bullets.get(index).needsRepaint())
				return true;
		}
		return false;
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
	
	public void fireGun(int x, int y){
		bullets.add(new Bullet((int)centerx,(int)centery,x,y));
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
		
		int centerx = (int)this.centerx;
		int centery = (int)this.centery;
		
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
		
		for(int index=0; index<bullets.size(); index++){
			bullets.get(index).drawBullet(g);
		}
		for(int index=0; index<bullets.size(); index++){
			if(bullets.get(index).isdone()){
				bullets.remove(index);
				moving = true;
			}
		}
	}
	public void shipRotated(double theta,int x, int y) {
		double xdistance = Math.abs(centerx - x);
		double ydistance = Math.abs(centery - y);
		double totaldistance = Math.sqrt( xdistance*xdistance + ydistance*ydistance);
		
		centerx = x;
		centery = y;
	
		xdistance = (totaldistance*Math.cos(Math.toRadians(theta)));
		ydistance = (totaldistance*Math.sin(Math.toRadians(theta)));
		
		centerx += xdistance;
		centery += ydistance;
	}
}
