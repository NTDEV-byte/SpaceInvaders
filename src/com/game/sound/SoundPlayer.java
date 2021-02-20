package com.game.sound;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
		

	
		private static String names[] = {"astro.wav","main.wav","shoot.wav"};
		private static HashMap<String,AudioInputStream> sounds = new HashMap<String,AudioInputStream>();
		private static Clip clip = getClip();
		public static SoundPlayer SP = new SoundPlayer();
		
					public SoundPlayer() { 
						loadSounds();
					//	play("main");
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
						close();
						try {
							clip.open(sounds.get(name));
						} catch (LineUnavailableException | IOException e) {
							e.printStackTrace();
						}
						clip.start();
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

}
