
public class P288 {

    static final long MODULO = pow(61, 10);

    public static void main(String args[]) {
        System.out.println(NF(61, 10000000));
    }

    static long pow(int base, int pow) {
        long result = 1;
        for (int i = 0; i < pow; i++) {
            result *= base;
        }
        return result;
    }

    static long NF(int p, int q) {
        long result = 0;
        long coef = 0;
        long S = 290797;
        for (int i = 0; i <= q; i++) {
            long T = S % p;
            result = addMod(result, multiplyMod(T, coef));
            S = S * S % 50515093;
            coef = addMod(multiplyMod(coef, p), 1);
        }
        return result;
    }

    static long multiplyMod(long a, long b) {
        return a * b % MODULO;
    }

    static long addMod(long a, long b) {
        return (a + b) % MODULO;
    }
}
