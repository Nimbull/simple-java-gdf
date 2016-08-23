package com.jamescho.game.model;

//Imports.
import java.awt.Rectangle;

import com.jamescho.framework.util.RandomNumberGenerator;
import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;

/*
 * <p>Ball.java - Handles game ball.</p>
 */
public class Ball {
	// Private members.
	private int x;
	private int y;
	private int width;
	private int height;
	private int velX;
	private int velY;
	private Rectangle rect;

	/**
	 * <p>Constructor.</p>
	 * 
	 * @param int that is the X position.
	 * @param int that is the Y position.
	 * @param int that is the width.
	 * @param int that is the height.
	 */
	public Ball(int inX, int inY, int inW, int inH) {
		this.x = inX;
		this.y = inY;
		this.width = inW;
		this.height = inH;
		velX = 5;
		velY = RandomNumberGenerator.getRandIntBetween(-4, 5);
		rect = new Rectangle(this.x, this.y, this.width, this.height);
	}

	/**
	 * <p>Updates the balls position on the game board.</p>
	 */
	public void update() {
		this.x += velX;
		this.y += velY;
		correctCollisions();
		updateRect();
	}

	/**
	 * <p>Corrects a Y collision.</p>
	 */
	private void correctCollisions() {
		if (this.y < 0) {
			y = 0;
		} else if (this.y + this.height > GameMain.GAME_HEIGHT) {
			y = GameMain.GAME_HEIGHT - this.height;
		} else {
			return;
		}

		this.velY = -velY;
		Resources.bounce.play();
	}

	/**
	 * <p>Updates the rectangles boundry.</p>
	 */
	private void updateRect() {
		rect.setBounds(this.x, this.y, this.width, this.height);
	}

	/**
	 * <p>Paddle collision detection.</p>
	 * 
	 * @param Paddle to check against.
	 */
	public void onCollideWith(Paddle inP) {
		if (this.x < GameMain.GAME_WIDTH / 2) {
			this.x = inP.getX() + inP.getWidth();
		} else {
			this.x = inP.getX() - this.width;
		}

		this.velX = -this.velX;
		this.velY += RandomNumberGenerator.getRandIntBetween(-2, 3);
	}

	/**
	 * <p>Check if ball goes off sides of screen.</p>
	 * 
	 * @return boolean TRUE if out, FALSE otherwise.
	 */
	public boolean isDead() {
		return (this.x < 0 || this.x + width > GameMain.GAME_WIDTH);
	}

	/**
	 * <p>Resets the ball after it goes out of play.</p>
	 */
	public void reset() {
		this.x = 300;
		this.y = 200;
		this.velX = 5;
		this.velY = RandomNumberGenerator.getRandIntBetween(-4, 5);
	}
}