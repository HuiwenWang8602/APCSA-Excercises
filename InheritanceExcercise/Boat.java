import java.awt.*;
public class Boat extends Vehicle
{
    public Boat()
    {
        super();
    }

    @Override
    public void paint(Graphics2D g)
    {
        g.drawLine(super.xPosition - 30, super.yPosition, super.xPosition + 20, super.yPosition + 75);
        g.drawLine(super.xPosition + 20, super.yPosition + 75, super.xPosition + 70, super.yPosition);
        super.paint(g);
    }
}
