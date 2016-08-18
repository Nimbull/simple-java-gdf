package com.jamescho.framework.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.jamescho.game.state.State;

public class InputHandler implements KeyListener, MouseListener {

	private State currentState;

	public void setCurrentState(State inState) {
		currentState = inState;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentState.onClick(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Do nothing.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Do nothing.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Do nothing.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Do nothing.
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Do nothing.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		currentState.onKeyPress(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentState.onKeyRelease(e);
	}

}
