public class Rational
{
    private int num, den, tNum, tDen;
    public Rational(int x, int y)
    {
        num = x;
        den = y;
    }

    public void add(Rational other){
        int test = den;

        num *= other.getDen();
        den *= other.getDen();

        tNum = other.getNum() * test;
        tDen = other.getDen() * test;

        System.out.println(simplify(num + tNum, den));
    }

    public void subtract(Rational other){
        int test = den;

        num *= other.getDen();
        den *= other.getDen();

        tNum = other.getNum() * test;
        tDen = other.getDen() * test;

        System.out.println(simplify(num - tNum, den));
    }

    public void multiply(Rational other){
        tNum = other.getNum();
        tDen = other.getDen();

        System.out.println(simplify(num * tNum, den * tDen));
    }

    public void divide(Rational other){
        tNum = other.getNum();
        tDen = other.getDen();

        System.out.println(simplify(num * tDen, den * tNum));
    }

    public String simplify(int x, int y){
        for(int i = x + y; i > 0; i--){
            if(x % i == 0 && y % i == 0){
                x/=i;
                y/=i;
            }
        }
        return x + "/" + y;
    }

    public String toString(){
        return simplify(num, den);
    }

    public int getNum(){
        return num;
    }

    public int getDen(){
        return den;
    }
}
