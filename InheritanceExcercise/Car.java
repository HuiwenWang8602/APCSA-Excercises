import java.awt.*;
public class Car extends Vehicle
{
    public Car()
    {
        super();
    }

    @Override
    public void paint(Graphics2D g)
    {
        g.setColor(super.colour);
        g.drawOval(super.xPosition - 15, super.yPosition  + 20, 20, 20);
        g.drawOval(super.xPosition + 35, super.yPosition  + 20, 20, 20);
        super.paint(g);
    }
}
