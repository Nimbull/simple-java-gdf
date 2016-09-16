package com.jamescho.framework.animation;

import java.awt.Graphics;

/*
 * <p>Animation.java - Simple class to hold animation frames and durations.</p>
 */
public class Animation {
	// Private members.
	private Frame[] frames;
	private double[] frameEndTimes;
	private int currentFrameIndex;
	private double totalDuration;
	private double currentTime;

	/**
	 * <p>Constructor.</p>
	 * 
	 * @param Frame[] is an array of animation frames to use.
	 */
	public Animation(Frame... inFrames) {
		// Variables.
		int c = 0;
		Frame f = null;

		// Initialize.
		this.currentFrameIndex = 0;
		this.totalDuration = 0;
		this.currentTime = 0;
		this.frames = inFrames;
		this.frameEndTimes = new double[this.frames.length];

		// Get durations.
		for (c = 0; c < frames.length; c++) {
			f = this.frames[c];
			this.totalDuration += f.getDuration();
			this.frameEndTimes[c] = this.totalDuration;
		}
	}

	/**
	 * <p>Animation update method.</p>
	 * 
	 * @param float the increment to update by.
	 */
	public synchronized void update(float inIncrement) {
		this.currentTime += inIncrement;

		if (this.currentTime > this.totalDuration) {
			wrapAnimation();
		}

		while (this.currentTime > this.frameEndTimes[this.currentFrameIndex]) {
			this.currentFrameIndex++;
		}
	}

	/**
	 * <p>Wrap the animation.</p>
	 */
	public synchronized void wrapAnimation() {
		this.currentFrameIndex = 0;
		this.currentTime %= this.totalDuration; // Equal to cT = cT % tD
	}

	/**
	 * <p>Draw the current animation frame.</p>
	 * 
	 * @param Graphics to draw by.
	 * @param int X location to draw.
	 * @param int Y location to draw.
	 */
	public synchronized void render(Graphics inG, int inX, int inY) {
		inG.drawImage(this.frames[this.currentFrameIndex].getImage(), inX, inY, null);
	}

	/**
	 * <p>Draw the current animation frame with width and height.</p>
	 * 
	 * @param Graphics to draw by.
	 * @param int X location to draw.
	 * @param int Y location to draw.
	 * @param int width to use.
	 * @param int height to use.
	 */
	public synchronized void render(Graphics inG, int inX, int inY, int inWidth, int inHeight) {
		inG.drawImage(this.frames[this.currentFrameIndex].getImage(), inX, inY, inWidth, inHeight, null);
	}
}