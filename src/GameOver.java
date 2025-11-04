import java.awt.*;

public class GameOver {
    public GameOver() {}


    public void noBoxesLeft(MagnetaBoxCollection mb, CyanBoxCollection cb, Ball ball, Bat bat) {
        if (mb.sizeOfArrayMagneta() + cb.sizeOfArrayCyan() == 0) {
            ball.setXSpeed(0);
            ball.setYSpeed(0);
            ball.setX(Constants.ballX - Constants.batShrinkFactor);
            ball.setY(Constants.ballY);
            bat.setX(Constants.batX);
            bat.setBatSpeed(0);
        }
    }

    public void ballsFinished(Ball ball, Bat bat) {
        if (ball.getChances() == 0) {
            if (bat.getWidth() == bat.getWidth()) {
                ball.setX(Constants.ballX);
            }
            if (bat.getWidth() == Constants.batWidth - Constants.batShrinkFactor) {
                ball.setX(Constants.ballX - (Constants.batShrinkFactor / 2));
            }
            if (bat.getWidth() == Constants.batWidth - (Constants.batShrinkFactor * 2)) {
                ball.setX(Constants.ballX - Constants.batShrinkFactor);
            }
            ball.setY(Constants.ballY);
            ball.setXSpeed(0);
            ball.setYSpeed(0);
            bat.setX(Constants.batX);
            bat.setBatSpeed(0);
        }
    }

    public void playerScore(Graphics2D graphics, CyanBoxCollection cyanBoxCollection, MagnetaBoxCollection magnetaBoxCollection, Ball ball) {
        graphics.setFont(new Font("Tahoma", Font.BOLD, 11));
        graphics.drawString("COLLECTED SCORE " + "<" + (cyanBoxCollection.getScoreCyan() + magnetaBoxCollection.getScoreMagneta()) + ">",Constants.collectedScoreX, Constants.collectedScoreY);
    }

    public void gameOverText(Graphics2D graphics, CyanBoxCollection cyanBoxCollection, MagnetaBoxCollection magnetaBoxCollection, Ball ball) {
        if (ball.getChances() == 0) {
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Tahoma", Font.BOLD, 50));
            graphics.drawString("GAME OVER", Constants.gameOverX, Constants.gameOverY);
            graphics.setFont(new Font("Tahoma", Font.BOLD, 12));
            graphics.drawString("COLLECTED SCORE " + "<" + (cyanBoxCollection.getScoreCyan() + magnetaBoxCollection.getScoreMagneta()) + ">",Constants.gameOverScoreX, Constants.gameOverScoreY);
        }
    }

    public void playerChancesLeft(Graphics2D graphics, Ball ball) {
        graphics.setFont(new Font("Tahoma", Font.BOLD, 11));
        graphics.drawString("CHANCES TO BURN " + "<" + (ball.getChances()) + ">",Constants.chancesToBurnX, Constants.chancesToBurnY);
    }

    public void playerWonText(Graphics2D graphics, CyanBoxCollection cyanBoxCollection, MagnetaBoxCollection magnetaBoxCollection) {
        if (magnetaBoxCollection.sizeOfArrayMagneta() + cyanBoxCollection.sizeOfArrayCyan() == 0) {
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Tahoma", Font.BOLD, Constants.gamePausedFontSize));
            graphics.drawString("PLAYER WON", Constants.playerWonX, Constants.getPlayerWonY);
            graphics.setFont(new Font("Tahoma", Font.BOLD, 12));
            graphics.drawString("COLLECTED SCORE " + "<" + (cyanBoxCollection.getScoreCyan() + magnetaBoxCollection.getScoreMagneta()) + ">",Constants.gameOverScoreX, Constants.gameOverScoreY);
        }
    }
}
