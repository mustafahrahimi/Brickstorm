import java.awt.*;

public class Game {
	// Fields .................................................................................
	CyanBoxCollection cyanBoxCollection;
	MagnetaBoxCollection magnetaBoxCollection;
	Ball ball;
	Bat bat;
	Frame gameFrame, infoFrame;
	boolean gameStarted;
	GameOver gameOver;

	// Constructor ...........................................................................
	public Game(GameBoard board) {
		gameOver = new GameOver();
		gameStarted = false;
		cyanBoxCollection = new CyanBoxCollection();
		magnetaBoxCollection = new MagnetaBoxCollection();
		ball = new Ball();
		bat = new Bat();
		gameFrame = new Frame();
		infoFrame = new Frame();
		infoFrame.setSpecifications(Constants.infoFrameX, Constants.infoFrameY, Constants.infoFrameWidth, Constants.infoFrameHeight);
	}

	// Methods ................................................................................
	public void update(Keyboard keyboard) {
		if (keyboard.isKeyDown(Key.Enter)) {
			gameStarted = true;
		}
		if (gameStarted) {
			bat.update(keyboard);
			ball.update(keyboard);

			if (bat.isCollidingWithBall(ball)) {
				ball.setY(ball.getY() - Constants.ballBounceFactor);
				ball.reverseYSpeed();
			}
			if (cyanBoxCollection.isCollidingWithCyan(ball)) {
				cyanBoxCollection.setColor(Colors.lightMagneta);
				ball.setY(ball.getY() + Constants.ballBounceFactor);
				ball.reverseYSpeed();
				cyanBoxCollection.removeCyanBox();
			}
			if (magnetaBoxCollection.isCollidingWithMagneta(ball)) {
				ball.reverseYSpeed();
				magnetaBoxCollection.removeMagnetaBox();
			}
			bat.variableBatWidth(magnetaBoxCollection, cyanBoxCollection);
		}

		gameOver.noBoxesLeft(magnetaBoxCollection, cyanBoxCollection, ball, bat);
		gameOver.ballsFinished(ball, bat);
	}

	public void draw(Graphics2D graphics) {
		cyanBoxCollection.draw(graphics);
		magnetaBoxCollection.draw(graphics);
		ball.draw(graphics);
		bat.draw(graphics);
		gameFrame.draw(graphics);
		infoFrame.draw(graphics);
		gameOver.playerChancesLeft(graphics, ball);
		gameOver.playerScore(graphics, cyanBoxCollection, magnetaBoxCollection, ball);
		gameOver.gameOverText(graphics, cyanBoxCollection, magnetaBoxCollection, ball);
		gameOver.playerWonText(graphics, cyanBoxCollection, magnetaBoxCollection);
	}
}
