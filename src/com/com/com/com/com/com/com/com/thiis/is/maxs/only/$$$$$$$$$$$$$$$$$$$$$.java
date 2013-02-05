package com.com.com.com.com.com.com.com.thiis.is.maxs.only;

import java.applet.Applet;
import java.awt.*;

public class $$$$$$$$$$$$$$$$$$$$$ extends Applet {
	private static final long serialVersionUID = 6430999995371909268L;
	public void init() {
		$$$$$$$$$$$$$$$$$$$$.$_00(200,200);
		setSize(400,400);
	}
	public void paint(Graphics g) {
		for (int x = 0; x < 200; x++) {
			for (int y = 0; y < 200; y++) {
				int lvl = (int)($$$$$$$$$$$$$$$$$$$$.$(x,y)*255);
				if (lvl > 255)
					lvl = 255;
				if (lvl < 0)
					lvl = 0;
				g.setColor(new Color(lvl,lvl,lvl));
				g.fillRect(x*2,y*2,2,2);
			}
		}
	}
}