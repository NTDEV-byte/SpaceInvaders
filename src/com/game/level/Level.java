package com.game.level;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.game.Game;
import com.game.entity.Crab;
import com.game.entity.Entity;
import com.game.entity.Octopus;
import com.game.entity.Player;
import com.game.entity.SpaceShip;
import com.game.entity.Squid;

public class Level {
	
	public static final int CRAB = 0;
	public static final int SQUID = 1;
	public static final int OCTOPUS = 2;
	
		private List<Entity> levelObjects;
		private Random random;
		
			public Level() { 
				levelObjects = new ArrayList<Entity>();
				random = new Random();
				levelObjects.add(new Player(new Rectangle((Game.WIDTH - 60) / 2, (Game.HEIGHT - 60) , 60,60)));
				generateMonsters(15,15,100,100,5,2);
			}

			public Level(int x,int y,int xSpace,int ySpace,int perC,int perL) { 
				levelObjects = new ArrayList<Entity>();
				random = new Random();
				levelObjects.add(new Player(new Rectangle((Game.WIDTH - 60) / 2, (Game.HEIGHT - 60) , 60,60)));
				generateMonsters(x,y,xSpace,ySpace,perC,perL);
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
		}
		
		public void render(Graphics g) { 
			for(Entity e : levelObjects) { 
				  e.render(g);
			}
		}

}
