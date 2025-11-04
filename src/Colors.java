import java.awt.*;

public class Colors extends Color {
    public static Colors white = new Colors(246, 245, 247);
    public static Colors lightMagneta = new Colors(255, 0, 255);
    public static Colors magneta = new Colors(0, 250, 154);
    public static Colors lightWhite = new Colors(220, 220, 220);

    public Colors(int r, int g, int b) {
        super(r, g, b);
    }
}
