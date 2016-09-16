package com.jamescho.framework.animation;

// Imports.
import java.awt.Image;

/*
 * <p>Frame.java - Simple class to hold an image and duration.</p>
 */
public class Frame {
	// Private members.
	private Image image;
	private double duration;

	/**
	 * <p>Constructor.</p>
	 * 
	 * @param Image to hold.
	 * @param double that is the duration for the image.
	 */
	public Frame(Image inImg, double inDur) {
		this.image = inImg;
		this.duration = inDur;
	}

	/**
	 * <p>Get the duration.</p>
	 * 
	 * @return double that is the duration.
	 */
	public double getDuration() {
		return this.duration;
	}

	/**
	 * <p>Get the image.</p>
	 * 
	 * @return Image that is stored here.
	 */
	public Image getImage() {
		return this.image;
	}
}