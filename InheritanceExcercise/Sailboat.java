import java.awt.*;
public class Sailboat extends Boat
{
    public Sailboat()
    {
        super();
    }

    @Override
    public void paint(Graphics2D g) {
        g.drawLine(xPosition - 30, yPosition, xPosition + 60, yPosition);
        g.drawLine(xPosition + 20, yPosition, xPosition + 20, yPosition - 50);
        g.drawLine(xPosition + 20, yPosition - 50, xPosition + 70, yPosition);
        super.paint(g);
    }

    @Override
    public void move() {
        xPosition += xDirection;
    }
}
