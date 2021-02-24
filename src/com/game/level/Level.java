package com.game.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

import com.game.Game;
import com.game.entity.Entity;
import com.game.entity.Player;
import com.game.entity.fires.Fire;
import com.game.entity.spaceships.Crab;
import com.game.entity.spaceships.Octopus;
import com.game.entity.spaceships.SpaceShip;
import com.game.entity.spaceships.Squid;
import com.game.gfx.Animation;

public class Level {
	
	public static final int CRAB = 0;
	public static final int SQUID = 1;
	public static final int OCTOPUS = 2;
	
	
	
	
		private static int wave = 1;
		private Vector<Entity> levelObjects;
		private Vector<Animation> animations;
		private Vector<Fire> fires;
		private Player player;
		private Random random;
		
			public Level() { 
				levelObjects = new Vector<Entity>();
				animations = new Vector<Animation>();
				fires = new Vector<Fire>();
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
		
		public synchronized void addEntity(Entity e) { 
			if(e instanceof Fire) {
				 fires.add((Fire)e);
				}
			else {
				levelObjects.add(e);
			}
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
			if(levelObjects.size() > 0) {
				for(Entity e : levelObjects) { 
					  e.update();
					}
				}
				if(animations.size() > 0) {
				for(Animation fa : animations) {
					fa.animate();
					}
				}
				if(fires.size() > 0) {
					for(Fire f : fires) {
						f.update();
					}
				}
				
				if(levelObjects.size() == 1) { 
					generateMonsters(15,15,100,100,5,2);
					wave++;
				}
			removeDestroyedSpaceShips();
			removeTerminatedAnimations();
			removeFires();
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
			if(fires.size() > 0) {
				for(Fire f : fires) {
					f.render(g);
				}
			}
			g.setColor(Color.red);
			g.drawString("Wave: "+wave, Game.WIDTH - 100, 80);
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

		private synchronized void removeFires() { 
			for(int i=0;i<fires.size();i++) {
				  if(fires.get(i).isRemoved()) {
					  fires.remove(i);
				  }
			}
		}
		

		public boolean playerHited() { 
			for(int i=0;i<fires.size();i++) {
				 if(fires.get(i).collision(player)) { 
					 return true;
				 }
			}
			
			return false;
		}
		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
		}

		public Vector<Entity> getLevelObjects() {
			return levelObjects;
		}

		public Vector<Animation> getAnimations() {
			return animations;
		}

		public Vector<Fire> getFires() {
			return fires;
		}

}
