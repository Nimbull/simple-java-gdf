package com.jamescho.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Resources {
	// Public members.
	public static BufferedImage welcome;
	public static BufferedImage iconImage;
	public static BufferedImage line;
	public static AudioClip hit;
	public static AudioClip bounce;
	public static Color darkBlue;
	public static Color darkRed;

	public static void load() {
		welcome = loadImage("welcome.png");
		iconImage = loadImage("iconimage.png");
		line = loadImage("line.png");
		hit = loadSound("hit.wav");
		bounce = loadSound("bounce.wav");
		darkBlue = new Color(25, 83, 105); // Accepts RGB values.
		darkRed = new Color(105, 13, 13); // Accepts RGB values.
	}

	private static AudioClip loadSound(String inFileName) {
		URL fileURL = Resources.class.getResource("/resources/" + inFileName);
		return Applet.newAudioClip(fileURL);
	}

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
