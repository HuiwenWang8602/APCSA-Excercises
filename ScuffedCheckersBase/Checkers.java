import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Checkers extends JFrame implements Runnable, MouseListener
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    Random ran;
    Chip chip; 
    Square [][] board = new Square[8][8];
    boolean canMove;
    Color c;
    public Checkers()
    {
        addMouseListener(this);
        con.setLayout(new FlowLayout());
        ran = new Random();
        canMove = false;

        t.start();
        for(int x = 0; x < board.length; x ++)
            for (int y =0; y < board[x].length; y ++)
                board[x][y] = new Square(x, y);
        chip = new Chip(25, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void moveStuff()
    {
        //chip.move();
    }

    public void drawStuff(Graphics2D g)
    {
        for(int x = 0; x < board.length; x ++)
            for (int y =0; y < board[x].length; y ++)
                board[x][y].draw(g);
        chip.draw(g);

    }

    public void run()
    {
        while(true)
        {
            try
            {
                t.sleep(33);
                //moveStuff();
                repaint();
            }
            catch(Exception e)
            {}
        }
    }

    public void paint(Graphics gr)
    {
        Image i=createImage(getSize().width, getSize().height);
        Graphics2D g = (Graphics2D)i.getGraphics();
        drawStuff(g);
        g.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        Checkers frame = new Checkers();
        frame.setSize(800, 700);//determines size of screen
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void mousePressed(MouseEvent m){}

    public void mouseEntered(MouseEvent m){}

    public void mouseExited(MouseEvent m){}

    public void mouseReleased(MouseEvent m){
        for(int x = 0; x < board.length; x ++)
            for (int y =0; y < board[x].length; y ++) 
                if(board[x][y].getRect().contains(m.getPoint()))
                {
                    System.out.println(board[x][y]);
                }

        if (chip.getRect().contains(m.getPoint())) 
            canMove = true;

        if (canMove) 
            for(int x = 0; x < board.length; x ++)
                for (int y =0; y < board[x].length; y ++) 
                    if(board[x][y].getRect().intersects(chip.getRect()))
                        c = board[x][y].getColour();

        for (int y = 0; y < board.length; y++) 
            for (int x = 0; x < board[y].length; x++) 
                if (canMove) 
                    if(board[x][y].getRect().contains(m.getPoint())) 
                        if (board[x][y].sameColour(c))
                            chip.move(board[x][y].getX(), board[x][y].getY());                       
                        else
                            System.out.println("You can't move here");

    }

    public void mouseClicked(MouseEvent m){}
}