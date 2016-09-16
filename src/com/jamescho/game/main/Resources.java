package com.jamescho.game.main;

// Imports.
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import com.jamescho.framework.animation.Animation;
import com.jamescho.framework.animation.Frame;

/* 
 * <p>Resources.java - The game resources class.</p>
 */
public class Resources {
	// Public members.
	public static BufferedImage welcome;
	public static BufferedImage iconImage;
	public static BufferedImage block;
	public static BufferedImage cloud1;
	public static BufferedImage cloud2;
	public static BufferedImage duck;
	public static BufferedImage grass;
	public static BufferedImage jump;
	public static BufferedImage selector;
	public static BufferedImage run1;
	public static BufferedImage run2;
	public static BufferedImage run3;
	public static BufferedImage run4;
	public static BufferedImage run5;
	public static AudioClip hit;
	public static AudioClip onJump;
	public static Color skyBlue;
	public static Animation runAnim;

	/**
	 * <p>Method that loads all game resources.</p>
	 */
	public static void load() {
		Frame f1 = null;
		Frame f2 = null;
		Frame f3 = null;
		Frame f4 = null;
		Frame f5 = null;

		welcome = loadImage("welcome.png");
		iconImage = loadImage("iconimage.png");
		block = loadImage("block.png");
		cloud1 = loadImage("cloud1.png");
		cloud2 = loadImage("cloud2.png");
		duck = loadImage("duck.png");
		grass = loadImage("grass.png");
		jump = loadImage("jump.png");
		run1 = loadImage("run_anim1.png");
		run2 = loadImage("run_anim2.png");
		run3 = loadImage("run_anim3.png");
		run4 = loadImage("run_anim4.png");
		run5 = loadImage("run_anim5.png");
		selector = loadImage("selector.png");
		hit = loadSound("hit.wav");
		onJump = loadSound("onjump.wav");
		skyBlue = new Color(208, 244, 247);
		f1 = new Frame(run1, 0.1f);
		f2 = new Frame(run2, 0.1f);
		f3 = new Frame(run3, 0.1f);
		f4 = new Frame(run4, 0.1f);
		f5 = new Frame(run5, 0.1f);
		runAnim = new Animation(f1, f2, f3, f4, f5, f3, f2);
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
