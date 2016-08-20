package com.jamescho.game.model;

import java.awt.Rectangle;

/*
 * <p>Paddle class to handle paddles for the game.</p>
 */
public class Paddle {
	// Private members.
	private int x;
	private int y;
	private int width;
	private int height;
	private int velY;
	private Rectangle rect;
	
	/**
	 * <p>Constructor.</p>
	 * 
	 * @param inX
	 * @param inY
	 * @param inWidth
	 * @param inHeight
	 */
	public Paddle(int inX, int inY, int inWidth, int inHeight) {
		this.x = inX;
		this.y = inY;
		this.width = inWidth;
		this.height = inHeight;
		this.rect = new Rectangle(this.x, this.y, this.width, this.height);
		this.velY = 0;
	}
}