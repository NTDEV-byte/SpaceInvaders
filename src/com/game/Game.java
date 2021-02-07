package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.level.Level;

public class Game extends JPanel{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static final int WIDTH = 800;
		public static final int HEIGHT = 600;
		
		private JFrame window;
		private Level level = new Level();
	//	private List<BufferedImage>  img = SpriteLoader.sprites.get("player");
		
		public Game() {
			window = new JFrame("SpaceInvaders");
			window.setVisible(true);
			window.setResizable(false);
			window.setLocationRelativeTo(null);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setPreferredSize(new Dimension(WIDTH,HEIGHT));
			window.add(this);
			window.pack();
			
		}
		
		
		public void paint(Graphics g) { 
			Graphics2D g2 = (Graphics2D)g;
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			level.update();
			level.render(g2);
			repaint();
		}
		
		
		public static void main(String args[]) { 
			  new Game();
		}
		

}