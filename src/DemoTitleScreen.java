import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Random;


@SuppressWarnings("serial")
public class DemoTitleScreen extends Applet {
	
	BufferedImage shadowOuter;
	Random rand;
	public void init() {
		setSize(640,480);
		
		shadowOuter = new BufferedImage(640,480,BufferedImage.TYPE_INT_ARGB);
		Graphics g = shadowOuter.getGraphics();
		Graphics2D g2 = (Graphics2D)g;
		Point2D center = new Point2D.Float(getWidth()/2, getHeight()/2);
        float radius = getWidth();
        Point2D focus = new Point2D.Float(getWidth()/2, getHeight()/2);
        float[] dist = {0.0f,0.3f, 1.0f};
        Color[] colors = {new Color(0,0,0,0),new Color(0,0,0,0), new Color(0,0,0,255)};
        RadialGradientPaint p = new RadialGradientPaint(center, radius, focus, dist, colors, CycleMethod.NO_CYCLE);
        g2.setPaint(p);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        rand = new Random();
        
        repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(67,67,120));
		g.fillRect(0, 100, 640, 480);
		
		g.setColor(new Color(50,100,150));
		g.fillRect(0,0,640,100);
		
		g.setColor(Color.white);
		((Graphics2D)g).setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Terminal", Font.BOLD, 24));
		g.drawString("Loading bar indicates amount of noise drawn", 0, 460);
		g.setFont(new Font("Arial Unicode MS", Font.PLAIN, 64));
		g.drawString("\u2601", 300, 75);
		g.drawString("\u2601", 100, 100);
		g.drawString("\u2601", 400, 100);
		g.setColor(Color.yellow);
		g.drawString("\u2600", 0, 75);
		
		for (int c = 0; c < 640*480; c++) {
			int x = rand.nextInt(640);
			int y = rand.nextInt(480-100)+100;
			int r = rand.nextInt(20) - 10;
			int g2 = rand.nextInt(20) - 10;
			int b = rand.nextInt(20) - 10;
			Color medium = new Color(80 + r, 80 + g2, 132 + b);
			g.setColor(medium);
			g.drawLine(x,y,x,y);
			
			g.setColor(new Color(30,255,40));
			g.fillRect(0, 460, (c * 640) / (640*480),10);
		}
		g.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		g.setColor(Color.gray);
		g.fillRect((640/2)-75, (480/2)-100, 150,48);
		g.fillRect((640/2)-75, (480/2)-42, 150,48);
		g.fillRect((640/2)-75, (480/2)+18, 150,48);
		g.setColor(Color.white);
		g.drawString("Start Game", (640/2)-60, (480/2)-70);
		g.drawString("Settings", (640/2)-43, (480/2)-12);
		g.drawString("Exit Game", (640/2)-53, (480/2)+53);
		
		g.drawImage(shadowOuter,0,0,null);
	}
}
