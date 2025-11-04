import java.awt.*;
import java.util.ArrayList;

public class CyanBoxCollection {
    // Fields
    private final ArrayList<ColoredBox> cyanBoxes;
    private final ArrayList<Rectangle> cyanRectangles;
    private final ArrayList<Integer> indexList;
    Ball ball;
    private int indexOfDamagedBox;
    private int scoreCyan;

    // Constructor
    public CyanBoxCollection() {
        scoreCyan = 0;
        cyanBoxes = new ArrayList<>();
        cyanRectangles = new ArrayList<>();
        indexList = new ArrayList<>();
        ball = new Ball();

        for (int i = 0; i < 4; i++) {
            cyanBoxes.add(new CyanBox(Constants.cyanBoxX + (i * Constants.spaceX), Constants.boxY, Constants.boxWidth, Constants.boxHeight));
            cyanRectangles.add(new Rectangle(Constants.cyanBoxX + (i * Constants.spaceX), Constants.boxY, Constants.boxWidth, Constants.boxHeight));
        }
    }

    // Metods
    public void update(Keyboard keyboard) {}

    public void draw(Graphics2D graphics) {
        for (ColoredBox cyanBox : cyanBoxes) {
            cyanBox.draw(graphics);
        }
    }

    public boolean isCollidingWithCyan(Ball ball) {
        Rectangle ballRect = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        for (Rectangle cyanRect : cyanRectangles) {
            if (ballRect.intersects(cyanRect)) {
                indexOfDamagedBox = cyanRectangles.indexOf(cyanRect);
                indexList.add(indexOfDamagedBox);
                return true;
            }
        }
        return false;
    }

    public void removeCyanBox() {
        int maxHit = 2;
        boolean found = false;
        int numberOfHits = 0;
        for (Integer index : indexList) {
            if (index == indexOfDamagedBox) {
                numberOfHits++;
            }
            if (numberOfHits == maxHit) {
                found = true;
                break;
            }
        }
        if (found) {
            cyanBoxes.remove(indexOfDamagedBox);
            cyanRectangles.remove(indexOfDamagedBox);
            scoreCyan += 2;
        }
    }

    public int getScoreCyan() {
        return scoreCyan;
    }
    public int sizeOfArrayCyan() {
        return cyanBoxes.size();
    }
    public Rectangle currentRect() {
        return cyanRectangles.get(indexOfDamagedBox);
    }
    public ColoredBox currentBox() {
        return cyanBoxes.get(indexOfDamagedBox);
    }
    public void setColor(Colors color) {cyanBoxes.get(indexOfDamagedBox).setColor(color);

    }
}


