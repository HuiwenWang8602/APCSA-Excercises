/**
 * Finding number of vowels in a string
 */

import java.util.*;
public class Vowels
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print(getVowels(input.nextLine()));
    }

    public static int getVowels(String s){
        int count = 0;
        for(int x = 0; x < s.length(); x++){
            String test;
            boolean positive = true;
            test = s.substring(x, x + 1).toLowerCase();
            positive = test.equals("a") || test.equals("e") || test.equals("i") || test.equals("o") || test.equals("u");
            if(positive){
                count++;
            }
        }
        return count;
    }
}
