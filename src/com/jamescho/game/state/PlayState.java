package com.jamescho.game.state;

import java.awt.Color;
import java.awt.Font;
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
	private int scoreLeft = 0;
	private int scoreRight = 0;
	private Font scoreFont;

	@Override
	public void init() {
		this.paddleLeft = new Paddle(0, 195, PlayState.PADDLE_WIDTH, PlayState.PADDLE_HEIGHT);
		this.paddleRight = new Paddle(785, 195, PlayState.PADDLE_WIDTH, PlayState.PADDLE_HEIGHT);
		this.scoreFont = new Font("SansSerif", Font.BOLD, 25);
	}

	@Override
	public void update() {
		paddleLeft.update();
		paddleRight.update();
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

		// Draw UI.
		g.setFont(this.scoreFont);
		g.drawString(new Integer(this.scoreLeft).toString(), 350, 40);
		g.drawString(new Integer(this.scoreRight).toString(), 435, 40);
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			paddleRight.accelUp();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			paddleRight.accelDown();
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			paddleLeft.accelUp();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			paddleLeft.accelDown();
		}
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP ||
				e.getKeyCode() == KeyEvent.VK_DOWN) {
			paddleRight.stop();
		} else if (e.getKeyCode() == KeyEvent.VK_W ||
				e.getKeyCode() == KeyEvent.VK_S) {
			paddleLeft.stop();
		}
			
	}

}
