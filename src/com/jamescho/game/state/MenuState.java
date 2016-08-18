package com.jamescho.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.Resources;

public class MenuState extends State {

	@Override
	public void init() {
		System.out.println("Enered MenuState");
	}

	@Override
	public void update() {
		// Do nothing.
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.welcome, 0, 0, null);
		
	}

	@Override
	public void onClick(MouseEvent e) {
		System.out.println("Number of clicks: " + e.getClickCount());
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		System.out.println("Key pressed: " + e.getKeyCode());
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		System.out.println("Key released: " + e.getKeyCode());
	}

}
