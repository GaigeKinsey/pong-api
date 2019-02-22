package edu.neumont.kinsey.controller;

import edu.neumont.kinsey.view.PongView;

public class PongController {

	private PongView view;
	private boolean ballHittable;
	private int ballPosX;
	private int paddle1PosX;
	private int paddleWidth;
	private int ballPosY;
	private int ballSize;
	private int paddle1PosY;
	private int paddleHeight;
	private int ballXVel;
	private int ballYVel;
	private int paddle2PosX;
	private int paddle2PosY;
	
	public PongController(PongView view) {
		this.view = view;
		this.view.registerController(this);
	}

	public void run() {
		this.view.init();
	}
	

	public void physics() {
		// Only check to see if the ball can be hit after passing the middle
		if (ballHittable) {
			// Left paddle hit
			if (ballPosX <= paddle1PosX + paddleWidth && ballPosX >= paddle1PosX && ballPosY + ballSize >= paddle1PosY
					&& ballPosY <= paddle1PosY + paddleHeight) {
				ballHittable = false;
				ballXVel *= -1;

				// Change ballYVelocity based on distance to center of paddle
				int centerOffset = (ballPosY - ballSize / 2) - (paddle1PosY + paddleHeight / 2);

				ballYVel = (int) (centerOffset * .3);
			}

			// Right paddle hit
			if (ballPosX + ballSize >= paddle2PosX && ballPosX + ballSize <= paddle2PosX + paddleWidth
					&& ballPosY + ballSize >= paddle2PosY && ballPosY <= paddle2PosY + paddleHeight) {
				ballHittable = false;
				ballXVel *= -1;

				// Change ballYVelocity based on distance to center of paddle
				int centerOffset = (ballPosY - ballSize / 2) - (paddle2PosY + paddleHeight / 2);

				ballYVel = (int) (centerOffset * .3);
			}
		}
	}
}
