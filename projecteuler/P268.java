
import java.util.ArrayList;
import java.util.Arrays;

public class P268 {

    static ArrayList<Integer> primes;
    static final long LIMIT = 10000000000000000L;

    public static void main(String args[]) {
        final int PRIME_LIMIT = 100;
        sievePrimes(PRIME_LIMIT);
        long answer = 0;
        long min = primes.get(0) * primes.get(1) * primes.get(2);
        int flag = 1;
        for (int primeNum = 4; (min *= primes.get(primeNum - 1)) <= LIMIT; primeNum++) {
            long factor = C(primeNum - 1, 3);
            long sum = subset(primeNum, 0, 1);
            answer += flag * factor * sum;
            flag = -flag;
        }
        System.out.println(answer);
    }

    static long subset(int rest, int index, long product) {
        if (rest == 0) {
            return LIMIT / product;
        }
        long sum = 0;
        for (int i = index; i < primes.size(); i++) {
            long nextProduct = product * primes.get(i);
            if (nextProduct > LIMIT) {
                break;
            }
            sum += subset(rest - 1, i + 1, nextProduct);
        }
        return sum;
    }

    static long C(int n, int k) {
        long result = 1;
        for (int i = n; i > n - k; i--) {
            result *= i;
        }
        for (int i = 1; i <= k; i++) {
            result /= i;
        }
        return result;
    }

    static void sievePrimes(int limit) {
        primes = new ArrayList<Integer>();
        boolean isPrimes[] = new boolean[limit];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                primes.add(i);
                for (int j = i + i; j < isPrimes.length; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
    }
}
