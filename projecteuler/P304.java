
import java.math.BigInteger;
import java.util.Arrays;

public class P304 {

    static final long MODULO = 1234567891011L;

    public static void main(String args[]) {
        final int LIMIT = 100000;
        final long FIRST = 100000000000000L;
        final int PRIME_SIZE = 5000000;
        final int BASE_PRIME_SIZE = 10010000;
        boolean primes[] = new boolean[PRIME_SIZE];
        boolean basePrimes[] = new boolean[BASE_PRIME_SIZE];
        Arrays.fill(primes, true);
        Arrays.fill(basePrimes, true);
        for (int i = 2; i < basePrimes.length; i++) {
            if (basePrimes[i]) {
                for (int j = i + i; j < basePrimes.length; j += i) {
                    basePrimes[j] = false;
                }
                int begin = (i - (int) (FIRST % i)) % i;
                for (int j = begin; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
        int count = LIMIT;
        long answer = 0;
        long temp[] = fibonacci(FIRST);
        long f = temp[0];
        long fPrev = temp[1];
        for (int i = 0; i < primes.length && count > 0; i++) {
            if (primes[i]) {
                answer = (answer + f) % MODULO;
                count--;
            }
            long fNext = (f + fPrev) % MODULO;
            fPrev = f;
            f = fNext;
        }
        System.out.println(answer);
    }

    static long[] fibonacci(long index) {
        index--;
        long t[][] = new long[][]{{1, 1}, {1, 0}};
        long trans[][] = new long[][]{{1, 0}, {0, 1}};
        while (index != 0) {
            if (index % 2 == 1) {
                trans = multiply(trans, t);
            }
            t = multiply(t, t);
            index /= 2;
        }
        long result[][] = multiply(new long[][]{{1, 0}}, trans);
        return result[0];
    }

    static long[][] multiply(long a[][], long b[][]) {
        long c[][] = new long[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] = (c[i][j] + new BigInteger(a[i][k] + "").multiply(new BigInteger(b[k][j] + "")).mod(new BigInteger(MODULO + "")).longValue()) % MODULO;
                }
            }
        }
        return c;
    }
}