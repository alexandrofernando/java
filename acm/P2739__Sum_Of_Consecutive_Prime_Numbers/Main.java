package P2739__Sum_Of_Consecutive_Prime_Numbers;

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
        } while (true) {
            int number = cin.nextInt();
            if (number == 0) {
                break;
            }
            int result = 0;
            for (int i = 0; i < primes.length && primes[i] <= number; i++) {
                int sum = 0;
                int pos = i;
                while (sum < number && pos < primes.length) {
                    sum += primes[pos];
                    pos++;
                }
                if (sum == number) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
