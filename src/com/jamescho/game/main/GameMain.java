package com.jamescho.game.main;

// Imports.
import javax.swing.JFrame;

/* 
 * <p>GameMain.java - The game launcher class.</p>
 */
public class GameMain {
	// Private members.
	private static final String GAME_TITLE = "Ellio (Chapter 6)";
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

		sGame = new Game(GAME_WIDTH, GAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(sGame);
		frame.setIconImage(Resources.iconImage);
		frame.pack();
		frame.setVisible(true);
	}
}