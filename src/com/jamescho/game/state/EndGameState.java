package com.jamescho.game.state;
//Imports.
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;

/* 
* <p>EndGame.java - The game menu state implementation class.</p>
*/
public class EndGameState extends State {
	// Private members.
	private int leftScore;
	private int rightScore;

	/**
	 * <p>Sets the scores.</p>
	 * 
	 * @param int left score.
	 * @param int right score.
	 */
	public void setScores(int inL, int inR) {
		this.leftScore = inL;
		this.rightScore = inR;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#init()
	 */
	@Override
	public void init() {
		// Do nothing.
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#update()
	 */
	@Override
	public void update() {
		// Do nothing.
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.drawString("Player Left - " + this.leftScore + " Player Right - " +
				this.rightScore, GameMain.GAME_WIDTH / 5,
				(GameMain.GAME_HEIGHT / 4));
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onClick(java.awt.event.MouseEvent)
	 */
	@Override
	public void onClick(MouseEvent e) {
		setCurrentState(new MenuState());
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyPress(java.awt.event.KeyEvent)
	 */
	@Override
	public void onKeyPress(KeyEvent e) {
		// Do nothing.
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyRelease(java.awt.event.KeyEvent)
	 */
	@Override
	public void onKeyRelease(KeyEvent e) {
		// Do nothing.
	}
}