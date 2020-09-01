import java.awt.*;
public class Jeep extends Car
{
    public Jeep()
    {
        super();
    }

    public void paint(Graphics2D g) {
        g.setColor(colour);
        g.drawLine(xPosition + 5, yPosition, xPosition + 5, yPosition + 20);
        g.drawLine(xPosition + 10, yPosition, xPosition + 10, yPosition + 20);
        g.drawLine(xPosition + 30, yPosition, xPosition + 30, yPosition + 20);
        g.drawLine(xPosition + 35, yPosition, xPosition + 35, yPosition + 20);
        g.drawOval(xPosition - 10, yPosition - 20, 15, 15);
        g.drawOval(xPosition + 35, yPosition - 20, 15, 15);
        super.paint(g);
    }

    @Override
    public void bounce()
    {
        if (xPosition + 40 > 600 || xPosition < 40) {
            if(xDirection > 0) {
                xPosition = 560;
                yDirection = (int)(Math.random() * 12) + 1;
            }
            if(xDirection < 0) {
                xPosition = 40;
                yDirection = -(int)(Math.random() * 12) - 1; 
            }
            xDirection = 0;
        }
        if (yPosition + 40 > 600 || yPosition < 40) {
            if(yDirection > 0) {
                yPosition = 560;
                xDirection = -(int)(Math.random() * 12) - 1; 
            }
            if(yDirection < 0) {
                yPosition = 40;
                xDirection = (int)(Math.random() * 12) + 1;
            }
            yDirection = 0;
        }
    }
}
