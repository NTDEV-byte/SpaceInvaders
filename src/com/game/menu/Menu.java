package com.game.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.Game;
import com.game.input.InputHandler;
import com.game.sound.SoundPlayer;

public class Menu extends JPanel{
	
		
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static final int WIDTH = 400;
		public static final int HEIGHT = 600;
	
		public static final Font TITLEF = new Font("Verdana",Font.BOLD,30);
		public static final Font OPTIONS = new Font("Verdana",Font.BOLD,15);
		public static final Color MENU_COLOR = Color.green;
		
		
		public static final String TITLE = "SpaceInvaders";
		public static final String OPT1 = "New Game";
		public static final String OPT2 = "High Scores";
		public static final String OPT3 = "Help";
		public static final String OPT4 = "Quit";
	
		private static InputHandler input = Game.input;
		private static JFrame window = new JFrame("SpaceInvaders");
		
		
			public Menu()
			{ 
				setPreferredSize(new Dimension(WIDTH,HEIGHT));
				addMouseMotionListener(input);
				addMouseListener(input);
				window.setVisible(true);
				window.setResizable(false);
				window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				window.setLocationRelativeTo(null);
				window.add(this);
				window.pack();
			}
			
			
				public void paint(Graphics g) { 
					g.setColor(Color.black);
					g.fillRect(0, 0, WIDTH, HEIGHT);
					g.setFont(TITLEF);
					g.setColor(MENU_COLOR);
					g.drawString(TITLE, 90, 100);
					g.setFont(OPTIONS);
					g.drawString(OPT1, 150, 250);
					g.drawString(OPT2, 150, 350);
					g.drawString(OPT3, 150, 450);
					g.drawString(OPT4, 150, 550);
					if(input.getMouseB() == MouseEvent.BUTTON1) { 
						System.out.println("Hohow");
							SoundPlayer.SP.close();
							window.dispose();
							new Game();
							
					}
					repaint();
				}
		
				
				
		
	
			
}
