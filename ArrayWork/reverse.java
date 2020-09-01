public class reverse
{
    public static void main(String[] args)
    {
        String stuff [] = {"apple", "borscht", "cat", "dog", "elephant"};

        for(int x = 0; x < stuff.length / 2; x++){
            String temp = stuff [x];
            stuff [x] = stuff [(stuff.length - 1) - x];
            stuff [(stuff.length - 1) - x] = temp;
        }

        for(String z: stuff)
        {
            System.out.println(z);
        }
    }
}