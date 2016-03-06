package P2603__Brave_Balloonists;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int primes[] = new int[1229];
        primes[0] = 2;
        int primeNumber = 1;
        for (int i = 3; i <= 10000; i += 2) {
            boolean isPrime = true;
            for (int j = 0; j < primeNumber && primes[j] * primes[j] <= i; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                primes[primeNumber] = i;
                primeNumber++;
            }
        }
        int counts[] = new int[10001];
        for (int i = 0; i < 10; i++) {
            int number = cin.nextInt();
            int pos = 0;
            while (number != 1) {
                while (number % primes[pos] == 0) {
                    number /= primes[pos];
                    counts[primes[pos]]++;
                }
                pos++;
            }
        }
        int result = 1;
        for (int i = 0; i < primes.length; i++) {
            result = (result * (counts[primes[i]] + 1)) % 10;
        }
        System.out.println(result);
    }
}
