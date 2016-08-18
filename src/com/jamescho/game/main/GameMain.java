package com.jamescho.game.main;

import javax.swing.JFrame;

public class GameMain {
	// Private members.
	private static final String GAME_TITLE = "LoneBall (Chapter 5 SJGDF)";
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static Game sGame;

	/**
	 * Main method.
	 * 
	 * @param String[] of arguments.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame(GAME_TITLE);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		sGame = new Game(GAME_WIDTH, GAME_HEIGHT);
		frame.add(sGame);
		frame.setIconImage(Resources.iconImage);
		frame.pack();
		frame.setVisible(true);
	}

}
