package com.jamescho.game.main;

// Imports.
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

/* 
 * <p>Resources.java - The game resources class.</p>
 */
public class Resources {
	// Public members.
	public static BufferedImage welcome;
	public static BufferedImage iconImage;

	/**
	 * <p>Method that loads all game resources.</p>
	 */
	public static void load() {
		welcome = loadImage("welcome.png");
		iconImage = loadImage("iconimage.png");
	}

	/**
	 * <p>Loads an audio clip file.</p>
	 * 
	 * @param String that is the file name of the audio file.
	 * 
	 * @return AudioClip is the loaded audio clip.
	 */
	private static AudioClip loadSound(String inFileName) {
		URL fileURL = Resources.class.getResource("/resources/" + inFileName);
		return Applet.newAudioClip(fileURL);
	}

	/**
	 * <p>Loads an image file for the game.</p>
	 * 
	 * @param String that is the image file name.
	 * 
	 * @return BufferedImage of the image file loaded.
	 */
	private static BufferedImage loadImage(String inFileName) {
		BufferedImage img = null;

		try {
			img = ImageIO.read(Resources.class.getResource("/resources/" + inFileName));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return img;
	}
}
