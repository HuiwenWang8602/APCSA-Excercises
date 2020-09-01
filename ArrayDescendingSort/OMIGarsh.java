import java.util.*;
public class OMIGarsh
{
    public static void main(String[] args)
    {
        System.out.println();
        
        int ar[] = new int[25];

        int ct = 0;
        while(ct<ar.length)
        {
            ar[ct] = (int)(Math.random()*1000);
            ct++;
        }

        for(int y: ar)
        {
            System.out.print(y+" ");
        }

        
        for(int start = 0; start < ar.length; start++){
            int highNum = 0;
            int highIn = 0;
            int temp = 0;
            for(int x = start; x < ar.length; x++){  
                if(ar[x] > highNum){
                    highNum = ar[x];
                    highIn = x;

                    temp = ar[start];
                    ar[start] = ar[highIn];
                    ar[highIn] = temp;
                }
            }
        }

        System.out.println();
        System.out.println();
        for(int y: ar)
        {
            System.out.print(y+" ");
        }
    }
}
