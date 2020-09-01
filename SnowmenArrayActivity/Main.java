import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Main extends JFrame implements Runnable, MouseMotionListener
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    SnowMan ar[];
    File file;
    Scanner input;
    public Main()
    {
        con.setLayout(new FlowLayout());
        ar = new SnowMan[4];
        file = new File("SnoFile.dat"); 
        try{ 
            input = new Scanner(file);
            for(int x = 0; x < ar.length; x++){
                ar[x] = new SnowMan(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        addMouseMotionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();
    }

    public void run()
    {
        try{
            while(true)
            {
                t.sleep(120);//Smaller number == faster, larger == slower
                for(int x = 0; x < ar.length; x++){
                    ar[x].move();
                    ar[x].die();
                }
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
        for(int x = 0; x < ar.length; x++){
            ar[x].drawing(g);
        }
        g.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        Main frame = new Main();
        frame.setSize(800, 800);//determines size of screen
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void mouseDragged(MouseEvent m){
        for(int x = 0; x<ar.length; x++){
            if(ar[x].getRect().contains(m.getPoint())){
                ar[x].setLoc(m.getX(), m.getY());
            }
        }
    }

    public void mouseMoved(MouseEvent m){

    }
}

