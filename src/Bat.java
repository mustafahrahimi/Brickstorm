import java.awt.*;

public class Bat extends Sprite{
    Frame frame = new Frame();
    private int batSpeed = Constants.batSpeed;
    public Bat() {
        super(Constants.batX, Constants.batY, Constants.batWidth, Constants.batHeight);
    }

    @Override
    public void update(Keyboard  keyboard) {
        if (keyboard.isKeyDown(Key.Right)) {
            setX(getX() + batSpeed);
        }

        else if (keyboard.isKeyDown(Key.Left)) {
            setX(getX() - batSpeed);
        }

        if (getX() + getWidth() >= frame.getWidth()) {
            setX(frame.getWidth() - getWidth());
        }

        if (getX() <= frame.getX()) {
            setX(frame.getX() + Constants.mainFrameX);
        }
    }

    @Override
    public void draw(Graphics2D graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public boolean isCollidingWithBall(Ball ball) {
        Rectangle ballRect = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        Rectangle batRect = new Rectangle(getX(), getY(), getWidth(), getHeight());
        return ballRect.intersects(batRect);
    }

    public void variableBatWidth(MagnetaBoxCollection magnetaBoxCollection, CyanBoxCollection cyanBoxCollection) {
        if (magnetaBoxCollection.sizeOfArrayMagneta() + cyanBoxCollection.sizeOfArrayCyan() == Constants.eightyPercentOfBoxesRemained) {
            setWidth(Constants.batWidth - Constants.batShrinkFactor);
        }
        if (magnetaBoxCollection.sizeOfArrayMagneta() + cyanBoxCollection.sizeOfArrayCyan() == Constants.thirtySevenPercentOfBoxesRemained) {
            setWidth(Constants.batWidth - (Constants.batShrinkFactor * 2));
        }
    }

    public void setBatSpeed(int batSpeed) {
        this.batSpeed = batSpeed;
    }
}











