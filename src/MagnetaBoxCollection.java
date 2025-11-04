import java.awt.*;
import java.util.ArrayList;

public class MagnetaBoxCollection {
    private final ArrayList<ColoredBox> magnetaBoxes;
    private final ArrayList<Rectangle> magnetaRectangles;
    Ball ball;
    private int indexOfDamagedBox;
    private int scoreMagneta;

    public MagnetaBoxCollection() {
        scoreMagneta = 0;
        ball = new Ball();
        magnetaBoxes = new ArrayList<>();
        magnetaRectangles = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            magnetaBoxes.add(new MagnetaBox(Constants.magnetaBoxX + (i * Constants.spaceX), Constants.boxY, Constants.boxWidth, Constants.boxHeight));
            magnetaRectangles.add(new Rectangle(Constants.magnetaBoxX + (i * Constants.spaceX), Constants.boxY, Constants.boxWidth, Constants.boxHeight));
        }
    }

    public void update(Keyboard keyboard) {}

    public void draw(Graphics2D graphics) {
        for (ColoredBox magnetaBox : magnetaBoxes) {
            magnetaBox.draw(graphics);
        }
    }

    public boolean isCollidingWithMagneta(Ball ball) {
        Rectangle ballRect = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());

        for (Rectangle magnetaRect : magnetaRectangles) {
            if (ballRect.intersects(magnetaRect)) {
                indexOfDamagedBox = magnetaRectangles.indexOf(magnetaRect);
                return true;
            }
        }

        return false;
    }

    public void removeMagnetaBox() {
        magnetaBoxes.remove(indexOfDamagedBox);
        magnetaRectangles.remove(indexOfDamagedBox);
        scoreMagneta++;
    }

    public int getScoreMagneta() {
        return scoreMagneta;
    }

    public int sizeOfArrayMagneta() {
        return magnetaBoxes.size();
    }
}
