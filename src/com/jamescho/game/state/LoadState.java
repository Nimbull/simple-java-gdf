package com.jamescho.game.state;

// Imports.
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.Resources;

/* 
 * <p>LoadState.java - The game load state implementation class.</p>
 */
public class LoadState extends State {
	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#init()
	 */
	@Override
	public void init() {
		Resources.load();
		System.out.println("Resources loaded successfully!");
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#update()
	 */
	@Override
	public void update(float inDelta) {
		setCurrentState(new MenuState());
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onClick(java.awt.event.MouseEvent)
	 */
	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyPress(java.awt.event.KeyEvent)
	 */
	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyRelease(java.awt.event.KeyEvent)
	 */
	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}