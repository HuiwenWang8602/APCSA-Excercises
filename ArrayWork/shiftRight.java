public class shiftRight
{
    public static void main(String[] args)
    {
        String stuff [] = {"apple", "borscht", "cat", "dog", "elephant"};

        String last = stuff [(stuff.length - 1)];
        for(int x = (stuff.length - 1); x > 0; x--)
            stuff [x] = stuff [x - 1];
        stuff [0] = last;

        for(String z: stuff)
        {
            System.out.println(z);
        }
    }
}
