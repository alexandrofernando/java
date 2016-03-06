package P2909__Goldbach_s_Conjecture;

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
        boolean p[] = new boolean[32768];
        int primes[] = new int[3512];
        primes[0] = 2;
        p[2] = true;
        int primeNumber = 1;
        for (int i = 3; i <= 32768; i += 2) {
            boolean isPrime = true;
            for (int j = 0; primes[j] * primes[j] <= i; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                primes[primeNumber] = i;
                p[i] = true;
                primeNumber++;
            }
        } while (true) {
            int number = cin.nextInt();
            if (number == 0) {
                break;
            }
            int count = 0;
            for (int i = 0; primes[i] * 2 <= number; i++) {
                if (p[number - primes[i]] == true) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
