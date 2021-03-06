package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.input.InputHandler;
import com.game.level.Level;
import com.game.menu.Menu;
import com.game.sound.SoundPlayer;

public class Game extends JPanel{
		
		/**/
	
	public static Color FOND = new Color(0x0);
	
	private static final long serialVersionUID = 1L;
		public static final int WIDTH = 800;
		public static final int HEIGHT = 600;
		public static Level level = new Level();
		public static InputHandler input = new InputHandler();
		private JFrame window;
		
		public Game() {
			window = new JFrame("SpaceInvaders");
			window.setVisible(true);
			window.setResizable(false);
			window.setLocationRelativeTo(null);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setPreferredSize(new Dimension(WIDTH,HEIGHT));
			window.addKeyListener(input);
			window.add(this);
			window.pack();
			level.initLevel();
		}
		
		public void paint(Graphics g) { 
			Graphics2D g2 = (Graphics2D)g;
			g.setColor(FOND);
			g.fillRect(0, 0, getWidth(), getHeight());
			level.update();
			level.render(g2);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		
		public static void main(String args[]) { 
				mainSoundPlay();
				new Menu();
		}
		
		
		public static void mainSoundPlay() { 
			SoundPlayer sp = new SoundPlayer();
			SoundPlayer.soundThread = new Thread(sp,"Sound-thread");
			SoundPlayer.soundThread.start();
		}
}
