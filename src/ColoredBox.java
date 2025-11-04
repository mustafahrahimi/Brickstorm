import java.awt.*;

public class ColoredBox extends Sprite {
    // Fields .................................................................................
    private Colors color;
    // Constructors ...........................................................................
    public ColoredBox(int x, int y, int width, int height, Colors color) {
        super(x, y, width, height);
        this.color = color;
    }

    // Methods ................................................................................
    @Override
    public void update(Keyboard keyboard) {

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void setColor(Colors myColor) {
        this.color = myColor;
    }
}
