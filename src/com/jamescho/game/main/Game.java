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
		this.setPreferredSize(new Dimension(this.gameWidth, this.gameHeight));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.requestFocus();
	}

	/**
	 * <p>Sets the current state.</p>
	 * 
	 * @param com.jamescho.game.state.State is the current state passed in.
	 */
	public void setCurrentState(State newState) {
		System.gc();
		newState.init();
		this.currentState = newState;
		this.inputHandler.setCurrentState(this.currentState);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#addNotify()
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		this.initInput();
		this.setCurrentState(new LoadState());
		this.initGame();
	}

	/**
	 * <p>Initialize the game.</p>
	 */
	private void initGame() {
		this.running = true;
		this.gameThread = new Thread(this, "Game Thread");
		this.gameThread.start();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// Variables.
		long updateDurationMillis = 0;
		long sleepDurationMillis = 0;
		long beforeUpdateRender = 0;
		long deltaMillis = 0;

		while (this.running) {
			beforeUpdateRender = System.nanoTime();
			deltaMillis = updateDurationMillis + sleepDurationMillis;

			this.updateAndRender(deltaMillis);

			updateDurationMillis = (System.nanoTime() - beforeUpdateRender) /
					1000000L;
			sleepDurationMillis = Math.max(2, 17 - updateDurationMillis);
			try {
				Thread.sleep(sleepDurationMillis);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.exit(0);
	}

	/**
	 * <p>Updates and renders the game display.</p>
	 * 
	 * @param long that is the delta millisecond value.
	 */
	private void updateAndRender(long inDelMilis) {
		this.currentState.update(inDelMilis / 1000f);
		this.prepareGameImage();
		this.currentState.render(this.gameImage.getGraphics());
		this.renderGameImage(this.getGraphics());
	}

	/**
	 * <p>Prepare the game grid.</p>
	 */
	private void prepareGameImage() {
		// Variables.
		Graphics g = null;

		if(gameImage == null) {
			gameImage = createImage(gameWidth, gameHeight);
		}
		g = gameImage.getGraphics();
		g.clearRect(0, 0, gameWidth, gameHeight);
	}

	/**
	 * <p>Exit routine to leave the game.</p>
	 */
	public void exit() {
		this.running = false;
	}

	/**
	 * <p>Renders a game image.</p>
	 * 
	 * @param Graphics is the grpahics object used to render.
	 */
	private void renderGameImage(Graphics g) {
		if (this.gameImage != null) {
			g.drawImage(gameImage, 0, 0, null);
		}
		g.dispose();
	}

	/**
	 * <p>Initialize input handlers.</p>
	 */
	private void initInput() {
		this.inputHandler = new InputHandler();
		this.addKeyListener(inputHandler);
		this.addMouseListener(inputHandler);
	}
}
