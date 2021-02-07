package com.game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.gfx.Animation;

public abstract class SpaceShip extends Entity{

		protected Animation animation;
			
			public SpaceShip(String name,Rectangle bounds) { 
				 animation = new Animation(name);
				 this.image = animation.getAnimation();
				 this.bounds = bounds;
			}
			
			public void update() { 
				animation.animate();
				image = animation.getAnimation();
			}
			
			public void render(Graphics g) { 
				g.drawImage(image, bounds.x, bounds.y, bounds.width,bounds.height,null);
			}

			public Animation getAnimation() {
				return animation;
			}

			public void setAnimation(Animation animation) {
				this.animation = animation;
			}
	

			
}
