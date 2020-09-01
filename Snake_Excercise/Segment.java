import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public class Segment
{
    private int x, y;
    Color c;
    Rectangle r;
    String direction;
    boolean left, up, right, down;
    public Segment(int x, int y)
    {
        this.x = x;
        this.y = y;
        c = Color.BLUE;
        r = new Rectangle (x, y, 50, 50);
    }

    public void draw(Graphics2D g) {
        g.setColor(c);
        g.fill(r);
        g.setColor(Color.black);
        g.draw(r);
    }

    public void move(String s) {
        stringToBool(s);
        if (left) {
            x += -50;
            y += 0;
        }
        if (right) {
            x += 50;
            y += 0;
        }
        if (up) {
            x += 0;
            y += -50;
        }
        if (down) {
            x += 0;
            y += 50;
        }
        r.setLocation(x, y);
    }

    public void follow(Segment seg) {
        x = seg.getX();
        y = seg.getY();
        r.setLocation(x, y);
    }

    public void update(){
        r.setLocation(this.x, this.y);
    }

    public Rectangle getRect () {
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public void stringToBool(String s) {
        if (s.equals("left")) {
            left = true;
            up = false;
            right = false;
            down = false;
        }
        else if (s.equals("up")) {
            left = false;
            up = true;
            right = false;
            down = false;
        }
        else if (s.equals("right")) {
            left = false;
            up = false;
            right = true;
            down = false;
        }
        else if (s.equals("down")) {
            left = false;
            up = false;
            right = false;
            down = true;
        }
        else {
            ;
        }
    }
}
