package com.game.entity.fires;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.entity.Entity;
import com.game.gfx.Animation;
import com.game.gfx.SpriteLoader;

public class Fire extends Entity{
	
		
	protected Animation animation;
	protected Color color;
	
		public Fire(String name,Rectangle bounds) {
			if(SpriteLoader.sprites.containsKey(name)) {
				animation = new Animation(name);
				this.image = animation.getAnimation();
			}
			else{
				System.err.println("Fire: "+name+" not found !");
			}
			this.bounds = bounds;
		}
		
		
		public Fire(Color c,Rectangle bounds) {
			this.color = c;
			this.bounds = bounds;
		}
	

	@Override
		public void update() {
			bounds.y+=speed;
		
		}

	@Override
		public void render(Graphics g) {
			g.drawImage(image, bounds.x, bounds.y, bounds.width, bounds.height, null);
		}

}
