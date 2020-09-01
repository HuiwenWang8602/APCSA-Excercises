import java.util.*;
import java.awt.*;
public class Vehicle
{
    protected Color colour;
    protected int xPosition, yPosition, xDirection, yDirection;
    public Vehicle()
    {
        colour = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        xPosition = (int)(Math.random() * 300);
        yPosition = (int)(Math.random() * 300);
        xDirection = (int)(Math.random() * 8) + 1;
        yDirection = (int)(Math.random() * 8) + 1;
    }

    public void paint(Graphics2D g) {
        g.setColor(colour);
        g.drawLine(xPosition - 10, yPosition, xPosition + 20, yPosition + 45);
        g.drawLine(xPosition + 20, yPosition + 45, xPosition + 50, yPosition);
    }

    public void move() {
        xPosition += xDirection;
        yPosition += yDirection;
    }

    public void bounce() {
        if (xPosition + 20 > 600 || xPosition < 0)
            xDirection *= -1;
        if (yPosition + 30 > 600 || yPosition < 0)
            yDirection *= -1;
    }
}
