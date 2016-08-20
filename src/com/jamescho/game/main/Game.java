package com.jamescho.game.main;

// Imports.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.jamescho.framework.util.InputHandler;
import com.jamescho.game.state.LoadState;
import com.jamescho.game.state.State;

@SuppressWarnings("serial")

/* 
 * <p>Game.java - The game class.</p>
 */
public class Game extends JPanel implements Runnable {
	// Private members.
	private int gameWidth;
	private int gameHeight;
	private Image gameImage;
	private Thread gameThread;
	private volatile boolean running;
	private volatile State currentState;
	private InputHandler inputHandler;

	/**
	 * <p>Constructor.</p>
	 * 
	 * @param int that is the width.
	 * @param int that is the height.
	 */
	public Game(int inW, int inH) {
		this.gameWidth = inW;
		this.gameHeight = inH;
		setPreferredSize(new Dimension(this.gameWidth, this.gameHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
	}

	/**
	 * <p>Sets the current state.</p>
	 * 
	 * @param com.jamescho.game.state.State is the current state passed in.
	 */
	public void setCurrentState(State newState) {
		System.gc();
		newState.init();
		currentState = newState;
		inputHandler.setCurrentState(currentState);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#addNotify()
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		initInput();
		setCurrentState(new LoadState());
		initGame();
	}

	/**
	 * <p>Initialize the game.</p>
	 */
	private void initGame() {
		running = true;
		gameThread = new Thread(this, "Game Thread");
		gameThread.start();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (running) {
			currentState.update();
			prepareGameImage();
			currentState.render(gameImage.getGraphics());
			repaint();
			try {
				Thread.sleep(14);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.exit(0);
	}

	/**
	 * <p>Prepare the game grid.</p>
	 */
	private void prepareGameImage() {
		if(gameImage == null) {
			gameImage = createImage(gameWidth, gameHeight);
		}
		Graphics g = gameImage.getGraphics();
		g.clearRect(0, 0, gameWidth, gameHeight);
	}

	/**
	 * <p>Exit routine to leave the game.</p>
	 */
	public void exit() {
		running = false;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (gameImage == null) {
			return;
		}
		g.drawImage(gameImage, 0, 0, null);
	}

	/**
	 * <p>Initialize input handlers.</p>
	 */
	private void initInput() {
		inputHandler = new InputHandler();
		addKeyListener(inputHandler);
		addMouseListener(inputHandler);
	}
}
