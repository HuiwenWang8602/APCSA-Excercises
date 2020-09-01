import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Driver extends JFrame implements Runnable, KeyListener
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    boolean left, up, right, down;
    String direction;
    ArrayList<Segment> segs = new ArrayList<Segment>();
    Rectangle[][] grid;
    Fruit fruit;
    Color black, green, lightBlue;
    public Driver() {
        con.setLayout(new FlowLayout());
        direction = new String("");

        fruit = new Fruit((int)(Math.random()*12) * 50 + 100, (int)(Math.random()*12) * 50 + 100);  //fruit placed randomly
        segs.add(new Segment(150, 150));   //snake head is created 

        grid = new Rectangle[12][12];
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++)
                grid [r][c] = new Rectangle(r * 50 + 100, c * 50 + 100, 50, 50);

        black = Color.black;
        green = new Color (153, 255, 153);
        lightBlue = new Color (153, 255, 255);

        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();
    }

    public void run()
    {
        try{
            while(true)
            {
                t.sleep(120);
                hitFruit();
                followHead();   //followHead() has to be called first because it takes the position of the head before it moves

                moveHead();

                hitWall();
                hitBody();

                repaint();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics gr)
    {
        Image i=createImage(getSize().width, getSize().height);
        Graphics2D g = (Graphics2D)i.getGraphics();

        //grassfield or whatever
        g.setColor(green);
        g.fillRect(0, 0, getSize().width, getSize().height);

        //the boundaries
        g.setColor(black);
        g.fillRect(0, 0, getSize().width, 100);
        g.fillRect(0, 700, getSize().width, 100);
        g.fillRect(0, 0, 100, getSize().height);
        g.fillRect(700, 0, 1000, getSize().height);

        //the grid
        g.setColor(lightBlue);
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++)
                g.draw(grid[r][c]);
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++)
                g.draw(grid[r][c]);
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++)
                g.draw(grid[r][c]);

        g.setFont(new Font("Euphemia UCAS", Font.BOLD, 38));
        g.drawString("Press Arrow Keys to Start Moving Snake", 40, 90);

        //snake and fruit
        for (int x = 0; x < segs.size(); x++) 
            segs.get(x).draw(g);
        fruit.draw(g);

        g.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        Driver frame = new Driver();
        frame.setSize(800, 800);//determines size of screen
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void moveHead() {    //self explanatory
        segs.get(0).move(direction);
    }

    public void printStuff() {  //print stuff here if you want this was once helpful bc im stupid
        System.out.println(segs.size());
    }

    public void hitWall() { //boundaries
        if (segs.get(0).getX() > 650 || segs.get(0).getX() < 100 || segs.get(0).getY() > 750 || segs.get(0).getY() < 100){
            System.out.println("You died");
            System.exit(0);
        }
    }

    public void hitFruit() {    //if snake eats fruit
        if (segs.get(0).getRect().intersects(fruit.getRect())) {
            if (segs.get(0).isLeft())
                segs.add(new Segment(segs.get(segs.size()-1).getX() + 50, segs.get(segs.size()-1).getY()));
            if (segs.get(0).isRight())
                segs.add(new Segment(segs.get(segs.size()-1).getX() - 50, segs.get(segs.size()-1).getY()));
            if (segs.get(0).isUp())
                segs.add(new Segment(segs.get(segs.size()-1).getX(), segs.get(segs.size()-1).getY() - 50));
            if (segs.get(0).isDown())
                segs.add(new Segment(segs.get(segs.size()-1).getX(), segs.get(segs.size()-1).getY() + 50));

            fruit.move((int)(Math.random()*12) * 50 + 100, (int)(Math.random()*12) * 50 + 100);
            printStuff();
        }
    }

    public void hitBody() { //if snake runs into itself
        for (int i = 1; i < segs.size(); i++)
            if (segs.get(0).getRect().intersects(segs.get(i).getRect())) {
                System.out.println("You died");
                System.exit(0);
            }
    }

    public void followHead() {  //body follows head
        for (int i = segs.size() - 1 ; i > 0; i--) {
            if (direction.equals("left"))
                segs.get(i).follow(segs.get(i - 1));
            if (direction.equals("right"))
                segs.get(i).follow(segs.get(i - 1));
            if (direction.equals("up"))
                segs.get(i).follow(segs.get(i - 1));
            if (direction.equals("down"))
                segs.get(i).follow(segs.get(i - 1));
        }
    }

    public void keyPressed(KeyEvent k) {}

    public void keyReleased(KeyEvent k) {
        if (k.getKeyCode() == 37 && !(direction.equals("right"))) { //turn left UNLESS it is already going right
            direction = "left";
        }

        if (k.getKeyCode() == 38 && !(direction.equals("down"))) { //turn up UNLESS etc. etc.
            direction = "up";
        }

        if (k.getKeyCode() == 39 && !(direction.equals("left"))) { //turn right
            direction = "right";
        }

        if (k.getKeyCode() == 40 && !(direction.equals("up"))) { //turn down
            direction = "down";
        }
    }

    public void keyTyped(KeyEvent k) {}
}