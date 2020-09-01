import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class SnowMan
{
    private int x, y, xVel, yVel, red, green, blue;
    private Rectangle rec;    
    Color c;
    public SnowMan(int x, int y, int xVel, int yVel, int red, int green, int blue){
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        this.red = red;
        this.green = green;
        this.blue = green;
        
        c = new Color(this.red, this.green, this.blue);
        rec = new Rectangle(x - 14, y - 10, 44, 78);
    }

    public void drawing(Graphics2D e)
    {
        e.setColor(c);
        e.drawOval(x, y, 20, 20);
        e.drawOval(x - 2, y + 19, 24, 20);
        e.drawOval(x - 4, y + 38, 28, 20);
        e.draw(rec);
    }

    public void move()
    {
        x += xVel;
        y += yVel;
        rec.setLocation(x - 14, y - 10);
    }

    public void die()
    {
        if (x < 0 || y < 0 || x > 800 || y > 700)
            System.exit(0);
    }
    
    public Rectangle getRect(){
        return rec;
    }
    
    public void setLoc(double mx, double my){
        x = (int)mx;
        y = (int)my;
        rec.setLocation(x - 14, y - 10);
    }
}
