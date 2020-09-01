public class Garfiled
{

    private int x;
    private String name= "";
    public Garfiled()
    {
        x = (int)(Math.random()*100);
        int z = 0;
        while (z<5)
        {
            name+=(char)((Math.random()*26)+65);
            z++;
        }
    }

    public String toString()
    {
        return name+",  "+x;
    }
    
    public String getName() {
        return name;
    }
    
    public int getX() {
        return x;
    } 
    
    public void changeName(String s) {
        name = s;
    }
}
