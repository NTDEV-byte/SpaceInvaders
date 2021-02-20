package com.game.entity;

import java.awt.Rectangle;

import com.game.entity.fires.LaserL;

public class Octopus extends SpaceShip{
		
			public Octopus(Rectangle bounds) { 
					super("octopus" , bounds);
			}

			@Override
			protected void shoot() {
				level.addEntity(new LaserL(new Rectangle(bounds.x,bounds.y,20,30),this));
			}

}
