package com.jpii.navalbattle.renderer.particles;


import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@SuppressWarnings("serial")
public class SmokeTest extends Applet {
	Random r = new Random();
	ParticleEngine fire;
	ParticleEngine smoke;
	public void init() {
		setSize(800,600);
		fire = new ParticleEngine(50,800,600);
		fire.setMaxParticles(100);
		smoke = new ParticleEngine(50,800,600);
		smoke.setMaxParticles(200);
	}
	public void paint(Graphics g2) {
		BufferedImage buffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		Graphics g = buffer.getGraphics();
		g.setColor(new Color(159,124,77));
		g.fillRect(375,460,50,15);
		for (int c = 0; c < r.nextInt(5)+5; c++) {
			FireParticle fp = new FireParticle(r,(float)(r.nextDouble() * 8) + 4);
			fp.setMaxHealth(10);
			fp.setX(400);
			fp.setY(450);
			fire.addParticle(fp);
		}
		for (int c = 0; c < r.nextInt(3)+3; c++) {
			SmokeParticle fp = new SmokeParticle(r,(float)(r.nextDouble() * 15) + 15);
			fp.setMaxHealth(r.nextInt(25) + 50);
			fp.setX(400+r.nextInt(60)-30-15);
			fp.setY(415);
			smoke.addParticle(fp);
		}
		g.drawImage(fire.getBuffer(),0,0,null);
		g.drawImage(smoke.getBuffer(),0,0,null);
		
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
