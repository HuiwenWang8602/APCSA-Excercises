public class Patient
{
    String firstName, lastName, medicalIssue;
    public Patient(String s1, String s2, String s3)
    {
        firstName = s1;
        lastName = s2;
        medicalIssue = s3;
    }

    public String toString(){
        return lastName + ", " + firstName + ". " + "Died from " + medicalIssue;
    }
    
}
