
public class ArraysLand
{
    public static void main(String [] args)
    {
        //making garfileds
        Garfiled gar[] = new Garfiled [50];
        for(int i = 0; i < gar.length; i++)
            gar[i] = new Garfiled();

        /*
        //testing for vowels
        int vCount = 0;
        for (int i = 0; i < gar.length; i++) {
        if (gar [i].getName().substring(0, 1).equalsIgnoreCase("A"))
        vCount++;
        if (gar [i].getName().substring(0, 1).equalsIgnoreCase("E"))
        vCount++;
        if (gar [i].getName().substring(0, 1).equalsIgnoreCase("I"))
        vCount++;
        if (gar [i].getName().substring(0, 1).equalsIgnoreCase("O"))
        vCount++;
        if (gar [i].getName().substring(0, 1).equalsIgnoreCase("U"))
        vCount++;
        }

        //printing out number of vowels
        System.out.println("There are " + vCount + "  Garfileds that start with a vowel.");
         */

        System.out.println();

        /*
        //removing first letter vowels and replacing them with consonants
        for (int i = 0; i < gar.length; i++) {
        if (gar [i].getName().substring(0, 1).equalsIgnoreCase("A")) {
        char temp = (char)(int)((Math.random()*26)+65);
        while (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U')
        temp = (char)(int)((Math.random()*26)+65);
        gar [i].changeName(temp + gar [i].getName().substring(1));
        }
        else if (gar [i].getName().substring(0, 1).equalsIgnoreCase("E")) {
        char temp = (char)(int)((Math.random()*26)+65);
        while (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U')
        temp = (char)(int)((Math.random()*26)+65);
        gar [i].changeName(temp + gar [i].getName().substring(1));
        }
        else if (gar [i].getName().substring(0, 1).equalsIgnoreCase("I")) {
        char temp = (char)(int)((Math.random()*26)+65);
        while (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U')
        temp = (char)(int)((Math.random()*26)+65);
        gar [i].changeName(temp + gar [i].getName().substring(1));
        }
        else if (gar [i].getName().substring(0, 1).equalsIgnoreCase("O")) {
        char temp = (char)(int)((Math.random()*26)+65);
        while (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U')
        temp = (char)(int)((Math.random()*26)+65);
        gar [i].changeName(temp + gar [i].getName().substring(1));
        }
        else if (gar [i].getName().substring(0, 1).equalsIgnoreCase("U")) {
        char temp = (char)(int)((Math.random()*26)+65);
        while (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U')
        temp = (char)(int)((Math.random()*26)+65);
        gar [i].changeName(temp + gar [i].getName().substring(1));
        }
        }
         */

        //removing Garfileds with x's below 10
        for (int i = 0; i < gar.length; i++) {
            Garfiled temp [];
            int garX = gar [i].getX();
            if (garX <  10) {
                temp = new Garfiled [(gar.length - 1)];
                for (int x = 0; x < i; x++) 
                    temp [x] = gar [x];
                for (int x = (i + 1); x < gar.length; x++) 
                    temp [x - 1] = gar [x];

                gar = new Garfiled [temp.length];
                for (int x = 0; x < gar.length; x++) {
                    gar [x] = temp [x];
                }
                i--;
            }
        }

        for(int x = 0; x < gar.length; x++) {   //prints values of Garfiled
            System.out.println(gar[x]);
        }
        
        System.out.println("\nScroll all the way up terminal window to see number of vowels, if that is uncommented.");

    }
}
