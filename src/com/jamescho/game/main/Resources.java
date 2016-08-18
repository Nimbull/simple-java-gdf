package com.jamescho.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Resources {
	// Public members.
	public static BufferedImage welcome;
	public static BufferedImage iconImage;

	public static void load() {
		welcome = loadImage("welcome.png");
		iconImage = loadImage("iconimage.png");
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
