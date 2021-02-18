package com.game.gfx;

import java.awt.Graphics;

public class FlashAnimation extends Animation{
	
	
	private int x,y;
	private int w,h;
	private boolean end;
	private Animation a;

	public FlashAnimation(Animation a,int x,int y,int w,int h) {
		this.a = a;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public FlashAnimation(Animation a,int rate,int x,int y,int w,int h) {
		this.a = a;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void update() {
		 a.animate();
		 if(a.fullCircle) { 
			 end = true;
		 }
	}
	
	public void render(Graphics g) { 
		g.drawImage(frame, x, y, w,h, null);
	}
	
	public boolean terminated() { 
		return end;
	}
}
