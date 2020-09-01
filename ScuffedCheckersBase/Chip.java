import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;   

public class Chip
{
    private int x, y;
    private Rectangle r;
    private Color c;
    public Chip(int x, int y)
    {
        c = Color.red;
        this.x = x;
        this.y = y;
        r = new Rectangle(x, y, 50, 50);
    }

    public void draw(Graphics2D g)
    {
        g.setColor(c);
        g.fillOval(x, y, 50, 50);   
    }

    public Rectangle getRect()
    {
        return r;
    }
    
    public void move() {
        x = x;
        y = y;
    }
    
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
