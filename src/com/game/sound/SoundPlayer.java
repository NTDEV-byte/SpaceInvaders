package com.game.sound;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
		

	
		
		private static Clip clip = getClip();
		public static SoundPlayer SP = new SoundPlayer("/main.wav",true);
		
					public SoundPlayer(String path,boolean url) { 
						if(url)	openSoundURL(path);
						else openSound(path);
					}
					
					private static Clip getClip() { 
						try {
							return AudioSystem.getClip();
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						}
						return null;
						
					}
					
					public void openSound(String path) { 
						try {
							clip.open(AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile()));
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							e.printStackTrace();
						}
					}
					
					
					public void openSoundURL(String name) { 
						try {
							URL u = SoundPlayer.class.getResource(name);
							clip.open(AudioSystem.getAudioInputStream(u));
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							e.printStackTrace();
						}
					}
					

					public void play(String path) {
						stop();
						clip.start();
						loop();
					}
					
					public void play() {
						clip.start();
					}
					
					
					public void stop() {
						 clip.stop();
					}
					
					public void loop() { 
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
	
					

}
