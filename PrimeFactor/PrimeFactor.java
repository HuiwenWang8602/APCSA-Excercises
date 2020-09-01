import java.util.*;
public class PrimeFactor
{
    public static void main(String[] args){
        System.out.print("Enter a number to be tested for it's prime factors: ");
        
        Scanner input;
        input = new Scanner(System.in);
        int dividend = input.nextInt();        

        for(int divisor = 2; divisor <= dividend / 2; divisor++){
            int temp = 1;
            int count = 0;
            boolean prime = true;
            if(dividend % divisor == 0){
                while(temp <= divisor){
                    if(divisor % temp == 0){
                        count++;
                    }
                    if(count > 2){
                        prime = false;
                        break;
                    }
                    temp++;
                }
                if(prime){
                    System.out.println(divisor + " is a prime factor of " + dividend);
                }
            }
        }
    }
}
