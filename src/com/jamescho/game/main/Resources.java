package com.jamescho.game.main;

// Imports.
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
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
	public static BufferedImage line;
	public static AudioClip hit;
	public static AudioClip dead;
	public static AudioClip bounce;
	public static Color darkBlue;
	public static Color darkRed;
	public static BufferedImage ball;
	public static BufferedImage gameOver;

	/**
	 * <p>Method that loads all game resources.</p>
	 */
	public static void load() {
		welcome = loadImage("welcome.png");
		iconImage = loadImage("iconimage.png");
		gameOver = loadImage("gameover.png");
		line = loadImage("line.png");
		ball = loadImage("ball2.png");
		hit = loadSound("hit.wav");
		dead = loadSound("hesdeadj.wav");
		bounce = loadSound("bounce.wav");
		darkBlue = new Color(25, 83, 105); // Accepts RGB values.
		darkRed = new Color(105, 13, 13); // Accepts RGB values.
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
