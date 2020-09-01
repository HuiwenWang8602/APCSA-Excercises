public class SumAverageAndMode
{
    public static void main(String [] args)
    {
        System.out.println();

        Garfiled gar[] = new Garfiled[5];
        int garVal [] = new int [gar.length];
        int freq [] = new int [100];

        int sum = 0, average = 0, mode = 0;
        for(int x = 0; x < gar.length; x++){    // creating array of integer values of the Garfileds
            gar[x] = new Garfiled();
            garVal [x] = gar [x].getInt();
        }

        //bubblesorting the arrays
        for (int f = 0; f < (garVal.length - 1); f++){
            for (int i = 0; i < (garVal.length - 1) - f; i++){
                if (garVal [i] > garVal [i + 1])
                {
                    int temp = garVal [i];
                    garVal [i] = garVal [i + 1];
                    garVal [i + 1] = temp;

                    Garfiled tempG = gar [i];
                    gar [i] = gar [i + 1];
                    gar [i + 1] = tempG;
                }
            }
        }

        //sum and average implementation
        for (int i = 0; i < garVal.length; i++){
            sum += garVal [i];
            average += garVal [i];            
        }
        average /= garVal.length;  

        //finding frequency of each number in the array of integer values from the Garfields
        for (int i = 0; i < garVal.length; i++)
            freq [garVal [i]]++;

        //finding how many times the most frequently used value is used   
        int modeIndex [] = new int [freq.length];
        int highFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq [i] >= highFreq){
                highFreq = freq [i];
            }
        }

        //and finding all the modes from each value that is generated the most frequently
        for (int i = 0; i < freq.length; i++) {
            if (freq [i] == highFreq) {
                modeIndex [i]++; // any value that is not 0 will be represented as a mod
            }
        }

        for (int x = 0; x < gar.length; x++)
        {
            System.out.println(gar[x]);
        }

        System.out.print("\nThe sum of all 5 Garfiled's is " + sum + ", \nthe average is " + average + ", \nand the mode/s is/are ");
        for (int i = 0; i < modeIndex.length; i++){
            if (modeIndex [i] != 0) 
                System.out.print(i + ", ");
        }
        System.out.print("which has/have a frequency of " + highFreq + ".");
    }
}
