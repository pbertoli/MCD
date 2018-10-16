package prova;

public class Prova {

    public static void main(String args[]) {
        int mcd;
        try {
            mcd = mcd(-76, 46);
        } catch (ExceptionParams e) {
            mcd = 0;
        }
        System.out.println(mcd);
    }

    public static int mcd(int a, int b)
            throws ExceptionParams {
        if (a < 0) {
            throw new ExceptionParams(1, a);
        }
        if (b < 0) {
            throw new ExceptionParams(2, b);
        }
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

    private static class ExceptionParams extends Exception {

        public ExceptionParams(int e, int p) {
            String msg = " parametro negativo: " + p;
            switch (e) {
                case 1:
                    msg = "Primo" + msg;
                    break;
                case 2:
                    msg = "Secondo" + msg;
                    break;
                default:
                    msg = "Errore nell'eccezione";
            }
            System.out.println(msg);
        }
    }
}
