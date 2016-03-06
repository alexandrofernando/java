package P1595__Prime_Cuts;

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
        int primes[] = new int[169];
        primes[0] = 1;
        primes[1] = 2;
        int primeNumber = 2;
        for (int i = 3; i <= 1000; i += 2) {
            boolean isPrime = true;
            for (int j = 1; j < primeNumber; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                primes[primeNumber] = i;
                primeNumber++;
            }
        } while (cin.hasNextInt() == true) {
            int N = cin.nextInt();
            int C = cin.nextInt();
            System.out.print(N + " " + C + ":");
            int index = 0;
            for (int i = primes.length - 1; i >= 0; i--) {
                if (primes[i] <= N) {
                    index = i;
                    break;
                }
            }
            int bottom;
            int top;
            if (index % 2 == 0) {
                bottom = index / 2 - C + 1;
                top = index / 2 + C - 1;
            } else {
                bottom = index / 2 - C + 1;
                top = index / 2 + C;
            }
            if (bottom < 0) {
                bottom = 0;
            }
            if (top > index) {
                top = index;
            }
            for (int i = bottom; i <= top; i++) {
                System.out.print(" " + primes[i]);
            }
            System.out.println();
            System.out.println();
        }
    }
}
