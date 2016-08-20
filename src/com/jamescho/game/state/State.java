package com.jamescho.game.state;

// Imports.
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.GameMain;

/* 
 * <p>State.java - The game state abstract class.</p>
 */
public abstract class State {
	/**
	 * <p>Initialize method.</p>
	 */
	public abstract void init();

	/**
	 * <p>Update method.</p>
	 */
	public abstract void update();

	/**
	 * <p>Render method.</p>
	 * 
	 * @param Graphics is the graphics object to use.
	 */
	public abstract void render(Graphics g);

	/**
	 * <p>Handles click events.</p>
	 * 
	 * @param MouseEvent is the mouse event to process.
	 */
	public abstract void onClick(MouseEvent e);

	/**
	 * <p>Handles key press events.</p>
	 * 
	 * @param KeyEvent is the key event to check.
	 */
	public abstract void onKeyPress(KeyEvent e);

	/**
	 * <p>Handles key release events.</p>
	 * 
	 * @param KeyEvent is the key event to check.
	 */
	public abstract void onKeyRelease(KeyEvent e);

	/**
	 * <p>Sets the current state.</p>
	 * 
	 * @param com.jamescho.game.state.State is the current state passed in.
	 */
	public void setCurrentState(State newState) {
		GameMain.sGame.setCurrentState(newState);
	}
}