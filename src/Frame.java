import java.awt.*;

public class Frame extends Sprite {
    public Frame() {
        super(Constants.mainFrameX, Constants.mainFrameY, Constants.mainFrameWidth, Constants.mainFrameHeight);
    }

    @Override
    public void update(Keyboard keyboard) {

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Colors.lightWhite);
        Stroke stroke = new BasicStroke(0f);
        graphics.setStroke(stroke);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    public void setSpecifications(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }
}
