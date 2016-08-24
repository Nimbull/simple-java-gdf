package com.jamescho.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;
import com.jamescho.game.model.Ball;
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
	private Ball ball;
	private static final int BALL_DIAMETER = 40;

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#init()
	 */
	@Override
	public void init() {
		this.paddleLeft = new Paddle(0, 195, PlayState.PADDLE_WIDTH, PlayState.PADDLE_HEIGHT);
		this.paddleRight = new Paddle(785, 195, PlayState.PADDLE_WIDTH, PlayState.PADDLE_HEIGHT);
		this.scoreFont = new Font("SansSerif", Font.BOLD, 25);
		this.ball = new Ball(300, 200, PlayState.BALL_DIAMETER, PlayState.BALL_DIAMETER);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#update()
	 */
	@Override
	public void update() {
		// Variables.
		EndGameState state = null;

		// Updates.
		paddleLeft.update();
		paddleRight.update();
		ball.update();

		// Ball collision detection.
		if (this.ballCollides(this.paddleLeft)) {
			this.scoreLeft++;
			this.ball.onCollideWith(this.paddleLeft);
			Resources.hit.play();
		} else if (this.ballCollides(this.paddleRight)) {
			this.scoreRight++;
			this.ball.onCollideWith(this.paddleRight);
			Resources.hit.play();
		} else if (this.ball.isDead()) {
			Resources.dead.play();
			if (this.ball.getX() < 0) {
				this.scoreLeft--;
			} else {
				this.scoreRight--;
			}
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.ball.reset();
		}

		// Win situation?
		if (this.scoreLeft == 15 || this.scoreRight == 15) {
			// Yep.
			state = new EndGameState();
			state.setScores(this.scoreLeft, this.scoreRight);
			setCurrentState(state);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#render(java.awt.Graphics)
	 */
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

		// Draw the ball.
		g.drawImage(Resources.ball, this.ball.getX(), this.ball.getY(), null);

		// Draw UI.
		g.setFont(this.scoreFont);
		g.drawString(new Integer(this.scoreLeft).toString(), 350, 40);
		g.drawString(new Integer(this.scoreRight).toString(), 435, 40);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onClick(java.awt.event.MouseEvent)
	 */
	@Override
	public void onClick(MouseEvent e) {
		// Do nothing.
	}

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyPress(java.awt.event.KeyEvent)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see com.jamescho.game.state.State#onKeyRelease(java.awt.event.KeyEvent)
	 */
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

	/**
	 * <p>Checks for ball/paddle collision.</p>
	 * 
	 * @param Paddle to check against.
	 * 
	 * @return boolean TRUE if collision, FALSE otherwise.
	 */
	private boolean ballCollides(Paddle inP) {
		return ball.getRect().intersects(inP.getRect());
	}
}
