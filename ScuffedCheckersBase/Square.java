import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Square
{
    private int x, y;
    private Rectangle r;
    private Color c;
    public Square(int x, int y)
    {
        this.x = x*50+25;
        this.y = y*50+50;
        r = new Rectangle(this.x, this.y, 50, 50);
        if((x+y)%2 == 1)
        {
            c = Color.white;
        }
        else
        {
            c = Color.black;
        }
    }

    public void draw(Graphics2D g)
    {
        g.setColor(c);
        g.fill(r);
        g.setColor(Color.black);
        g.draw(r);
    }

    public Rectangle getRect()
    {
        return r;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Color getColour() {
        return c;
    }
    
    public String toString()
    {
        return "This is the Square at "+x+", "+y+"; color is "+c;
    }

    public boolean sameColour(Color c) {
        if (this.c == c) 
            return true;
        else
            return false;
    }
}

