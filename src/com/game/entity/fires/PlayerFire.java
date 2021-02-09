package com.game.entity.fires;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerFire extends Fire{
	
	public static final int FIX_X = 32;
	public static final int FIX_Y = - 8;
	
	
	public PlayerFire(Color c, Rectangle bounds) {
		super(c, bounds);
	}

	public void update() {
		bounds.y-=speed;
		if(bounds.y <= 0) {
			 remove();
		}
	}

	public void render(Graphics g) { 
		g.setColor(color);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
