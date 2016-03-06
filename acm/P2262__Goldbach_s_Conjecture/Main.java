package P2262__Goldbach_s_Conjecture;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int prime[] = new int[1000000];
        do {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            boolean find = false;
            for (int i = 3; i + i <= n; i += 2) {
                if (prime[i] == 0) {
                    if (isPrime(i) == true) {
                        prime[i] = 1;
                    }
                    else {
                        prime[i] = -1;
                    }
                }
                if (prime[i] == 1) {
                    if (prime[n - i] == 0) {
                        if (isPrime(n - i) == true) {
                            prime[n - i] = 1;
                        }
                        else {
                            prime[n - i] = -1;
                        }
                    }
                    if (prime[n - i] == 1) {
                        System.out.println(n + " = " + i + " + " + (n - i));
                        find = true;
                        break;
                    }
                }
            }
            if (find == false) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
        while (true);
    }

    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
