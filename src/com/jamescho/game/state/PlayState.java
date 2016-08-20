package com.jamescho.game.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;
import com.jamescho.game.model.Paddle;

public class PlayState extends State {
	// Private members.
	private Paddle paddleLeft;
	private Paddle paddleRight;
	private static final int PADDLE_WIDTH = 15;
	private static final int PADDLE_HEIGHT = 60;

	@Override
	public void init() {
		this.paddleLeft = new Paddle(0, 195, PlayState.PADDLE_WIDTH, PlayState.PADDLE_HEIGHT);
		this.paddleRight = new Paddle(785, 195, PlayState.PADDLE_WIDTH, PlayState.PADDLE_HEIGHT);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// Draw background.
		g.setColor(Resources.darkBlue);
		g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
		g.setColor(Resources.darkRed);
		g.fillRect(GameMain.GAME_WIDTH / 2, 0, GameMain.GAME_WIDTH / 2,
				GameMain.GAME_HEIGHT);

		// Draw line.
		g.drawImage(Resources.line, (GameMain.GAME_WIDTH / 2) - 2, 0, null);

		// Draw paddles.
		g.setColor(Color.WHITE);
		g.fillRect(this.paddleLeft.getX(), this.paddleLeft.getY(),
				this.paddleLeft.getWidth(), this.paddleLeft.getHeight());
		g.fillRect(this.paddleRight.getX(), this.paddleRight.getY(),
				this.paddleRight.getWidth(), this.paddleRight.getHeight());
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}