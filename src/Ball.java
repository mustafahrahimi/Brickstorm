import java.awt.*;

public class Ball extends Sprite{
    Frame frame = new Frame();
    private int chances;
    private int xSpeed = Constants.ballXSpeed;
    private int ySpeed = Constants.ballYSpeed;

    // constructor
    public Ball() {
        super(Constants.ballX, Constants.ballY, Constants.ballWidth, Constants.ballHeight);
        chances = Constants.numberOfBallsFromStart;
    }

    int maxFrameWidth = (frame.getWidth()) - getWidth();
    int maxFrameHeight = frame.getHeight() - getHeight();

    // methods
    @Override
    public void update(Keyboard keyboard) {
        setX(getX() - xSpeed);
        setY(getY() - ySpeed);

        if (getX() > maxFrameWidth || getX() < Constants.mainFrameX) {
            xSpeed = -xSpeed;
        }

        if (getY() < Constants.mainFrameY) {
            ySpeed = -ySpeed;
        }

        if (isBallLost()) {
            chances--;
            setX(Constants.lostBallX);
            setY(Constants.lostBallY);
            if (chances % 2 != 0) {
                xSpeed = -xSpeed;
            }
        }
    }

    @Override
    public void draw(Graphics2D graphics)  {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    public void reverseYSpeed ()  {
        ySpeed = -ySpeed;
    }

    public boolean isBallLost() {
        int gameBoardHeight = Constants.mainFrameHeight + Constants.mainFrameY; // 450
        return getY() > gameBoardHeight;
    }

    public int getChances() {
        return chances;
    }

    public int getXSpeed() {
        return xSpeed;
    }
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    public int getYSpeed() {
        return ySpeed;
    }
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}
