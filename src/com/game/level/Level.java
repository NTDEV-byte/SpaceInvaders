package com.game.level;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

import com.game.Game;
import com.game.entity.Crab;
import com.game.entity.Entity;
import com.game.entity.Octopus;
import com.game.entity.Player;
import com.game.entity.SpaceShip;
import com.game.entity.Squid;
import com.game.gfx.Animation;

public class Level {
	
	public static final int CRAB = 0;
	public static final int SQUID = 1;
	public static final int OCTOPUS = 2;
	
		private Vector<Entity> levelObjects;
		private Vector<Animation> animations;
		private Player player;
		private Random random;
		
			public Level() { 
				levelObjects = new Vector<Entity>();
				animations = new Vector<Animation>();
				random = new Random();
			}

			public void initLevel() {
				player = new Player(new Rectangle((Game.WIDTH - 60) / 2, (Game.HEIGHT - 60) , 60,60));
				levelObjects.add(player);
				generateMonsters(15,15,100,100,5,2);
			}
			
			public void initLevel(int x,int y,int xSpace,int ySpace,int perC,int perL) { 
				player = new Player(new Rectangle((Game.WIDTH - 60) / 2, (Game.HEIGHT - 60) , 60,60));
				levelObjects.add(player);
				generateMonsters(x,y,xSpace,ySpace,perC,perL);
			}

			
		public synchronized void addAnimation(Animation a) { 
			animations.add(a);
		}
		
		private void generateMonsters(int xstart,int ystart,int xS,int yS,int perC,int perL) { 
			int tempX = xstart;
			int tempY = ystart;
			
			 for(int y=0;y<perL;y++) {
				 for(int x=0;x<perC;x++) {
					 levelObjects.add(randomMonster(tempX,tempY));
					 tempX+=xS;
				 }
				 tempX = xstart;
				 tempY+=yS;
			 }
		}
		
		private SpaceShip randomMonster(int x,int y){ 
			  int type = random.nextInt(3);
			  switch(type) { 
			  case CRAB:
				  return new Crab(new Rectangle(x,y,SpaceShip.WIDTH,SpaceShip.HEIGHT));
			  case SQUID:
				  return new Squid(new Rectangle(x,y,SpaceShip.WIDTH,SpaceShip.HEIGHT));
			  case OCTOPUS:
				  return new Octopus(new Rectangle(x,y,SpaceShip.WIDTH,SpaceShip.HEIGHT));
			  }
			  return new Crab(new Rectangle(x,y,SpaceShip.WIDTH,SpaceShip.HEIGHT));  
		}
			
		public void update() { 
			for(Entity e : levelObjects) { 
				e.update();
			}
			for(Animation a : animations) { 
				a.animate();
			}
			removeDestroyedSpaceShips();
			removeTerminatedAnimations();
		}
		
		public void render(Graphics g) {
			if(levelObjects.size() > 0) {
			for(Entity e : levelObjects) { 
				  e.render(g);
				}
			}
			if(animations.size() > 0) {
			for(Animation fa : animations) {
				fa.render(g);
				}
			}
		}
		
		private synchronized void removeDestroyedSpaceShips() { 
			for(int i=0;i<levelObjects.size();i++) {
				  if(levelObjects.get(i).isRemoved() && levelObjects.size() > 0) {
					   levelObjects.remove(i);
				  }
			}
		}
		
		private synchronized void removeTerminatedAnimations() { 
			for(int i=0;i<animations.size();i++) {
				  if(animations.get(i).fullRotation() || animations.get(i).isRendred()) {
					   animations.remove(i);
				  }
				 
			}
		}
		
		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
		}

}
