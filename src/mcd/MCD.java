package mcd;

public class MCD {

    public static void main(String[] args) {
        System.out.println(mcd(0, 12));
    }

    public static int mcd(int a, int b) {
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        if (b == 0) {
            return a;
        } else {
            return mcd(b, a % b);
        }
    }
}

class ExceptionParameters extends Exception {

}
