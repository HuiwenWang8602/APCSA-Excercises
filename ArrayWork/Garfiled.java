public class Garfiled
{   
    private int x;
    private String name = "";
    public Garfiled()
    { 
        x = (int) (Math.random()*100);
        int z = 0;
        while (z < 5)
        {
            name += (char) ((Math.random() * 26) + 65);
            z++;
        }
    }

    public String toString()
    { 
        return name + ", " + x;
    }
    
    public int getInt(){
        return x;
    }
}
