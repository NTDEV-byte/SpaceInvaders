package com.game.sound;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer implements Runnable{
		
	
		public static Thread soundThread;
		public static SoundPlayer SP = new SoundPlayer();
		public static Scanner sc = new Scanner(System.in);
	
			
		private static String names[] = {"astro.wav","main.wav","shoot.wav","explosion.wav"};
		private static HashMap<String,AudioInputStream> sounds = new HashMap<String,AudioInputStream>();
		private static Clip clip = getClip();
		private static boolean playing = true;
		
		
		
					public SoundPlayer() { 
					}
					
					private static Clip getClip() { 
						try {
							return AudioSystem.getClip();
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						}
						return null;
					}
					
					private void loadSounds() {
						for(int i=0;i<names.length;i++) { 
						  sounds.put(names[i].split("\\.")[0], openSoundURL("/"+names[i]));
						}
					}
					
					
					public AudioInputStream openSoundURL(String name) { 
						try {
							URL u = SoundPlayer.class.getResource(name);
							return AudioSystem.getAudioInputStream(u);
						} catch (IOException e) {
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							e.printStackTrace();
						}
						return null;
					}
					

					public void play(String name) {
						loadSound(name);
						clip.setFramePosition(0);
						clip.start();
					}
					
					public void loadSound(String name) { 
						if(!clip.isOpen()) {
							System.out.println("open !");
							try {
								clip.open(sounds.get(name));
							} catch (LineUnavailableException | IOException e) {
								e.printStackTrace();
							}
						  }
						}
					
					public void stop() {
						 clip.stop();
					}
					
					public void close() { 
						clip.close();
					}
					
					public void loop() { 
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}

					
					public void actions() { 
						System.out.println("Enter name of action: ");
							String input = sc.next();
							if(input.equalsIgnoreCase("play")) { 
								System.out.println("Enter Sound name to Play: ");
								String sound_name = sc.next();
								if(sound_name.equalsIgnoreCase(names[0]) && sound_name.equalsIgnoreCase(names[1]) && sound_name.equalsIgnoreCase(names[2])) { 
									   play(sound_name);
								}
							}
							else 
								if(input.equalsIgnoreCase("stop")) { 
										stop();
								}
								else 
									if(input.equalsIgnoreCase("close")) { 
										close();
									}
						}
					
					public void run() {
						loadSounds();
						play("main");
						
						while(playing);
						
						soundThread.stop();
					}
					
					public void quit() { 
						playing = false;
					}
}
