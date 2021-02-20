package com.game.entity.fires;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import com.game.entity.Crab;
import com.game.entity.Entity;
import com.game.entity.Octopus;
import com.game.entity.SpaceShip;
import com.game.entity.Squid;
import com.game.gfx.Animation;
import com.game.gfx.SpriteLoader;

public class Fire extends Entity{
	
		
	protected Animation animation;
	protected Color color;
	protected SpaceShip shooter;
	
		public Fire(String name,Rectangle bounds,SpaceShip ship) {
			if(SpriteLoader.sprites.containsKey(name)) {
				animation = new Animation(name);
				this.image = animation.getAnimation();
			}
			else{
				System.err.println("Fire: "+name+" not found !");
			}
			this.bounds = bounds;
			this.shooter = ship;
		}
		
		
		public Fire(Color c,Rectangle bounds) {
			this.color = c;
			this.bounds = bounds;
		}
	
		@Override
		public void update() {
			bounds.y+=speed;
			collisionWithSpaceShips();
		}
	
		private void collisionWithSpaceShips() { 
			List<Entity> objects = level.getLevelObjects();
			for(int i=0;i<objects.size();i++) {
				 if(objects.get(i) instanceof SpaceShip) {
					  	SpaceShip s = (SpaceShip)(objects.get(i));
					  	if(collision(s) && shooter != s && notEnnemie(s)) { 
					  		remove();
					  	}
				 }
			}
		}
		
		private boolean notEnnemie(SpaceShip s) { 
			return (!(s instanceof Crab) && !(s instanceof Octopus) && !(s instanceof Squid));
		}

	@Override
		public void render(Graphics g) {
			g.drawImage(image, bounds.x, bounds.y, bounds.width, bounds.height, null);
		}

}
