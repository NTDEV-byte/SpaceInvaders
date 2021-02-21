package com.game.entity.spaceships;

import java.awt.Rectangle;

import com.game.entity.fires.LaserL;

public class Octopus extends SpaceShip{
		
		public static final int SHOOT_OFFSET_X = 15;
		public static final int SHOOT_OFFSET_Y = 8;
		
			public Octopus(Rectangle bounds) { 
					super("octopus" , bounds);
			}

			@Override
			protected void shoot() {
				level.addEntity(new LaserL(new Rectangle(bounds.x + SHOOT_OFFSET_X,bounds.y + SHOOT_OFFSET_Y,10,15),this));
			}

}
