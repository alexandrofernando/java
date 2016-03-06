package P3292__Semi_prime_H_numbers;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-22
 * Time: 19:05:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean composites[] = new boolean[1000002];
        for (int i = 5; i < composites.length; i += 4) {
            if (composites[i] == false) {
                primes.add(i);
                if (i <= 1000) {
                    for (int j = i * i; j < composites.length; j += i * 4) {
                        composites[j] = true;
                    }
                }
            }
        }
        boolean semiPrimes[] = new boolean[1000002];
        for (int i = 0; i < primes.size(); i++) {
            int prime1 = primes.get(i);
            if (prime1 > 1000) {
                break;
            }
            for (int j = i; j < primes.size(); j++) {
                int prime2 = primes.get(j);
                int number = prime1 * prime2;
                if (number > 1000001) {
                    break;
                }
                semiPrimes[number] = true;
            }
        }
        int results[] = new int[1000002];
        int number = 0;
        for (int i = 5; i < semiPrimes.length; i += 4) {
            if (semiPrimes[i] == true) {
                number++;
            }
            results[i] = number;
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            int h = in.nextInt();
            if (h == 0) {
                break;
            }
            System.out.println(h + " " + results[h]);
        }
    }
}
