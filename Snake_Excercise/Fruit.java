import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public class Fruit
{
    int x, y;
    Color c;
    Rectangle r;
    public Fruit(int x , int y)
    {
        this.x = x;
        this.y = y;
        c = Color.RED;
        r = new Rectangle (this.x, this.y, 50, 50);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        r.setLocation(this.x, this.y);
    }

    public void draw(Graphics2D g) {
        g.setColor(c);
        g.fill(r);
        g.setColor(Color.black);
        g.draw(r);
    }

    public Rectangle getRect() {
        return r;
    }
}
