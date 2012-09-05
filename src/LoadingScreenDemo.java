import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class LoadingScreenDemo extends Applet implements Runnable {
	int x_pos = 919;
	int y_pos = 728;
	int count = 0;
	
	boolean reverse = true;

	private Image dbImage;
	private Graphics dbg;

	public void init() {
		setSize(1000,750);
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void stop() {

	}

	public void destroy() {

	}

	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

		while (true) {
			if(reverse)
				x_pos--;
			else
				x_pos++;
			
			if(x_pos == 885) {
				reverse = false;
			} else if(x_pos == 945) {
				reverse = true;
			}
			
			count++;

			repaint();

			try {
				// 500
				Thread.sleep(20);
			} catch (InterruptedException ex) {
			}

			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}

		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

		dbg.setColor(getForeground());
		paint(dbg);

		g.drawImage(dbImage, 0, 0, this);
	}

	public void paint(Graphics g) {
		g.setFont(new Font("sansserif", Font.PLAIN, 50));
		g.drawString("Level 1", 10, 50);
		g.setFont(new Font("sansserif", Font.PLAIN, 25));
		g.drawString("Single Player", 825, 50);
		g.drawLine(0, 60, 1000, 60);
		
		g.drawString("IMAGE HERE", 400, 350);
		
		g.drawLine(0, 700, 1000, 700);
		g.setFont(new Font("sansserif", Font.PLAIN, 12));
		
		g.drawString("Tips and useful info go here...", 10, 740);
		
		// Animation
		if(reverse) {
			g.drawString("Loading", 900, 740);
		} else {
			g.drawString("Level 1", 900, 740);
		}
		
		g.fillRect(x_pos, y_pos, 10, 15);
		
		
	}
}
