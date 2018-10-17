package mcd;

public class MCD {

    public static void main(String[] args) {
        try {
            System.out.println(mcd(-46, 12));
        } catch (ExceptionMcd e) {
            e.urlaErrore();
        }
    }

    public static int mcd(int a, int b)
            throws ExceptionMcd {
        // verifica delle precondizioni
        if (a < 0) {
            throw new ExceptionMcd(1);
        }
        if (b < 0) {
            throw new ExceptionMcd(2);
        }
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        if (b == 0) {
            // postcondizioni
            return a;
        } else {
            // postcondizioni
            int mcd = mcd(b, a % b);
            assert mcd >=0: "Errore di calcolo interno: mcd negativo.";
            assert a % mcd == 0 && b % mcd == 0:
                    "Errore: l'mcd non è nemmeno un divisore.";
            return mcd;
        }
    }

    private static class ExceptionMcd extends Exception {

        public ExceptionMcd(int nError) {
            String s = "";
            switch (nError) {
                case 1:
                    s = "Primo parametro negativo";
                    break;
                case 2:
                    s = "Secondo parametro negativo";
                    break;
                case 3:
                    s = "valore mcd negativo";
                    break;
                default:
                    s = "Eccezione non gestita";
            }
            System.out.println("Metodo MCD: " + s);
        }
        public void urlaErrore() {
            System.out.println("PORCA MISERIA");
        }
    }
}
