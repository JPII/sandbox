package com.jpii.navalbattle.renderer.particles;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@SuppressWarnings("serial")
public class ParticleTest extends Applet {
	Random r = new Random();
	ParticleEngine expl;
	public void init() {
		setSize(800,600);
		expl = new ParticleEngine(50,800,600);
		expl.setMaxParticles(500);
	}
	public void paint(Graphics g2) {
		BufferedImage buffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		Graphics g = buffer.getGraphics();
		for (int c = 0; c < r.nextInt(3); c++) {
			FireParticle fp = new FireParticle(r,(float)(r.nextDouble() * 15) + 10);
			//fp.setMaxHealth(r.nextInt(50) + 50);
			fp.setX(400);
			fp.setY(300);
			expl.addParticle(fp);
		}
		g.drawImage(expl.getBuffer(),0,0,null);
		
		try {
			Thread.sleep(50);
		}
		catch (Exception ex) {
			
		}
		g2.drawImage(buffer,0,0,null);
		repaint();
	}
	public void update(Graphics g) {
		paint(g);
	}
}
