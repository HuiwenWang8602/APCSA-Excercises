public class shiftLeft
{
    public static void main(String[] args)
    {
        String stuff[] = {"apple", "borscht", "cat", "dog", "elephant"};

        String first = stuff [0];
        for(int x = 0; x < (stuff.length - 1); x++)
            stuff [x] = stuff [x + 1];
        stuff [(stuff.length - 1)] = first;       

        for(String z: stuff)
        {
            System.out.println(z);
        }
    }

}