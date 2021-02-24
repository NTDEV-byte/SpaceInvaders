package com.game.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
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
	
		private static Rectangle bTitle,bOpt1,bOpt2,bOpt3,bOpt4;
		
		
		private static InputHandler input = Game.input;
		private static JFrame window = new JFrame("SpaceInvaders");
		
		
			public Menu()
			{ 
				setPreferredSize(new Dimension(WIDTH,HEIGHT));
				addMouseMotionListener(input);
				addMouseListener(input);
				window.setVisible(true);
				window.setResizable(false);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setLocationRelativeTo(null);
				window.add(this);
				window.pack();
				bTitle =  new Rectangle(90,75,250,30);
				bOpt1 =  new Rectangle(150,230,100,30);
				bOpt2 =  new Rectangle(150,330,105,30);
				bOpt3 =  new Rectangle(180,430,40,30);
				bOpt4 =  new Rectangle(180,530,40,30);
				
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
					g.drawString(OPT3, 180, 450);
					g.drawString(OPT4, 180, 550);
					onClick(g);

					
					//showBounds(g);
					repaint();
				}
		
				
				
				private void onClick(Graphics g) { 
					Point cursorLocation = new Point(input.getMouseX(),input.getMouseY());
					if(bTitle.contains(cursorLocation)) { 
						  		g.setColor(Color.white);
						  		g.setFont(TITLEF);
						  		g.drawString(TITLE, 90, 100);
					}
					else if(bOpt1.contains(cursorLocation)) {
						if(input.getMouseB() == MouseEvent.BUTTON1) {
							SoundPlayer.SP.close();
							window.dispose();
							new Game();
						}
					}
					
					
					else if(bOpt3.contains(cursorLocation)) {
						if(input.getMouseB() == MouseEvent.BUTTON1) {
							g.setColor(Color.white);
							g.drawString("Arrows for movements",150,150);
							g.drawString("SpaceBar to shoot",150,200);
							
						}
					}
					
					else if(bOpt4.contains(cursorLocation)) {
						if(input.getMouseB() == MouseEvent.BUTTON1) {
							SoundPlayer.SP.close();
							SoundPlayer.SP.quit();
							window.dispose();
						}
					}
				}
				
				
				private static void showBounds(Graphics g) { 
					g.setColor(Color.yellow);
					
					g.drawRect(bTitle.x, bTitle.y, bTitle.width, bTitle.height);
					g.drawRect(bOpt1.x, bOpt1.y, bOpt1.width, bOpt1.height);
					g.drawRect(bOpt2.x, bOpt2.y, bOpt2.width, bOpt2.height);
					g.drawRect(bOpt3.x, bOpt3.y, bOpt3.width, bOpt3.height);
					g.drawRect(bOpt4.x, bOpt4.y, bOpt4.width, bOpt4.height);
				}
				
				
		
	
			
}
