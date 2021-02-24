package com.game.entity.spaceships;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.entity.Entity;
import com.game.entity.Player;
import com.game.entity.fires.PlayerFire;
import com.game.gfx.Animation;
import com.game.gfx.SpriteLoader;

public abstract class SpaceShip extends Entity{
	
	
	
	public static final int EXPLOSION_TIME = 25;
	public static final int EXPLOSION_WIDTH = 40;
	public static final int EXPLOSION_HEIGHT = 40;
	public static final int RATE_DIRECTION = 200;
	public static final int RATE_FIRE = 500;
	public static final int WIDTH = 40;
	public static final int HEIGHT = 40;
	
		protected Animation animation;
		
		
			public SpaceShip(String name,Rectangle bounds) { 
				 if(!(this instanceof Player)) {
					 animation = new Animation(name);      
					 this.image = animation.getAnimation();
				 }else {
					 this.image = SpriteLoader.sprites.get("player").get(0);
				 }
				 
				 this.bounds = bounds;
			}
			
			public void update() { 
				if(timer < 7500) timer++;else timer = 0;
				if(timer % RATE_DIRECTION == 0) { 
					pickDirection();
					}
				checkCollisionWithWorld();
				bounds.x+=xDir;
				bounds.y+=yDir;
				animation.animate();
				image = animation.getAnimation();
				PlayerFire fire = level.getPlayer().getShootedFire();
				if(fire!=null) { 
					if(collision(fire)) { 
						 remove();
						 Player p = level.getPlayer();
						 p.setFire(null);
						 p.whenShipIsDestroyed();
						 animateExplosion();
					}
				}
				if(timer % RATE_FIRE == 0) { 
					shoot();
				}
			}
			
			private void animateExplosion() { 
				 Animation exp =  new Animation("explosion0",EXPLOSION_TIME);
				 exp.setAnimationLocation(bounds.x, bounds.y, EXPLOSION_WIDTH, EXPLOSION_HEIGHT);
				 level.addAnimation(exp);
			}
			
			protected abstract void shoot();
			
			private void pickDirection() {
				 xDir = random.nextInt(3) - 1;
			   //yDir = random.nextInt(3) - 1;
			}
			
			private void checkCollisionWithWorld() { 
				 if(this.collisionWithWorldH()) { 
					   xDir*=-1;
				 }
				 if(this.collisionWithWorldV()) {
					  yDir*=-1;
				 }
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
