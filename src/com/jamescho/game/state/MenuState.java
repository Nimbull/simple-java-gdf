package com.jamescho.game.state;

// Imports.
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.Resources;

/* 
 * <p>MenuState.java - The game menu state implementation class.</p>
 */
public class MenuState extends State {
	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#init()
	 */
	@Override
	public void init() {
		System.out.println("Enered MenuState");
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#update()
	 */
	@Override
	public void update(float inDelta) {
		// Do nothing.
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.welcome, 0, 0, null);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onClick(java.awt.event.MouseEvent)
	 */
	@Override
	public void onClick(MouseEvent e) {
		System.out.println("Number of clicks: " + e.getClickCount());
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyPress(java.awt.event.KeyEvent)
	 */
	@Override
	public void onKeyPress(KeyEvent e) {
		System.out.println("Key pressed: " + e.getKeyCode());
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyRelease(java.awt.event.KeyEvent)
	 */
	@Override
	public void onKeyRelease(KeyEvent e) {
		System.out.println("Key released: " + e.getKeyCode());
	}
}