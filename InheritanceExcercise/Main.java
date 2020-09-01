import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Main extends JFrame implements Runnable
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    Vehicle vehicle1;
    Vehicle vehicle2;
    Car car1;
    Car car2;
    Boat boat1;
    Boat boat2;
    Sailboat sailboat1;
    Sailboat sailboat2;
    Jeep jeep1;
    Jeep jeep2;
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public Main()
    {
        con.setLayout(new FlowLayout());

        // vehicle1 = new Vehicle();
        // vehicle2 = new Vehicle();
        // car1 = new Car();
        // car2 = new Car();
        // boat1 = new Boat();
        // boat2 = new Boat();
        // sailboat1 = new Sailboat();
        // sailboat2 = new Sailboat();
        // jeep1 = new Jeep();
        // jeep2 = new Jeep();
        vehicles.add(new Vehicle());
        vehicles.add(new Vehicle());
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Boat());
        vehicles.add(new Boat());
        vehicles.add(new Sailboat());
        vehicles.add(new Sailboat());
        vehicles.add(new Jeep());
        vehicles.add(new Jeep());

        t.start();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void run()
    {
        while(true)
        {
            try
            {
                t.sleep(24);
                // vehicle1.move();
                // vehicle2.move();
                // vehicle1.bounce();
                // vehicle2.bounce();

                // car1.move();
                // car2.move();
                // car1.bounce();
                // car2.bounce();

                // boat1.move();
                // boat2.move();
                // boat1.bounce();
                // boat2.bounce();

                // sailboat1.move();
                // sailboat2.move();
                // sailboat1.bounce();
                // sailboat2.bounce();

                // jeep1.move();
                // jeep2.move();
                // jeep1.bounce();
                // jeep2.bounce();
                for (int i = 0; i < vehicles.size(); i++)
                {
                    vehicles.get(i).move();
                    vehicles.get(i).bounce();
                }
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

        g.setColor(Color.black);
        g.fillRect(0, 0, getSize().width, getSize().height);

        // vehicle1.paint(g);
        // vehicle2.paint(g);

        // car1.paint(g);
        // car2.paint(g);

        // boat1.paint(g);
        // boat2.paint(g);

        // sailboat1.paint(g);
        // sailboat2.paint(g);

        // jeep1.paint(g);
        // jeep2.paint(g);

        for (int x = 0; x < vehicles.size(); x++)
            vehicles.get(x).paint(g);
       

        g.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        Main frame = new Main();
        frame.setSize(600, 600);    //determines size of screen
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    }
}