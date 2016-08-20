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
	private final static int MOVE_SPEED_Y = 4;
	
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

	/**
	 * <p>Performs a velocity update for this rectangle in the game.</p>
	 */
	public void update() {
		this.y += this.velY;
		updateRect();
	}

	/**
	 * <p>Updates the rectangle bounds.</p>
	 */
	private void updateRect() {
		this.rect.setBounds(this.x, this.y, this.width, this.height);
	}

	/**
	 * <p>Accelerate up method.</p>
	 */
	public void accelUp() {
		this.velY = -Paddle.MOVE_SPEED_Y;
	}

	/**
	 * <p>Accelerate down method.</p>
	 */
	public void accelDown() {
		this.velY = Paddle.MOVE_SPEED_Y;
	}

	/**
	 * <p>Stop paddle movement.</p>
	 */
	public void stop() {
		this.velY = 0;
	}

	/**
	 * <p>Gets the X position of the paddle.</p>
	 * 
	 * @return int that is the X position.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * <p>Gets the Y position of the paddle.</p>
	 * 
	 * @return int that is the Y position.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * <p>Gets the width of the paddle.</p>
	 * 
	 * @return int that is the width.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * <p>Gets the height of the paddle.</p>
	 * 
	 * @return int that is the height.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * <p>Gets the Rectangle object of the paddle.</p>
	 * 
	 * @return Rectangle is the Rectangle object of the paddle.
	 */
	public Rectangle getRect() {
		return this.rect;
	}
}