import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args){
        File file = new File("Teller.txt");
        Scanner input;
        Patient patient = new Patient("", "", "");
        try{
            input = new Scanner(file);
            while(input.hasNext()){
                String firstName = input.next();
                String secondName = input.next();
                String medicalIssue = input.next();
                
                patient = new Patient(firstName, secondName, medicalIssue);
            }
        }
        catch (Exception e){
            System.out.print("Whoops, try again I guess; exception: " + e);
        }
        System.out.print(patient);
    }
}
