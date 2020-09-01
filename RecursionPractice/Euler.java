public class Euler
{
    static int x = -1;
    public static void main (String[] args) {
        System.out.print(findEuler());
    }

    public static double findEuler(){
        if (x < 5000) 
            return 1/findFactorial(++x) + findEuler();

        else 
            return 0;
    }

    public static double findFactorial(double i) {
        if (i > 0)
            return i * findFactorial(i - 1);
        else
            return 1;
    }
}
