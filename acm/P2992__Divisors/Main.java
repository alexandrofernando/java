package P2992__Divisors;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 2:41:30
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        int primes[] = new int[83];
        primes[0] = 2;
        int primeNumber = 1;
        for (int i = 3; i <= 431; i += 2) {
            boolean isPrime = true;
            for (int j = 0; j < primeNumber; j++) {
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
        ArrayList<Prime_Count> numbers[] = new ArrayList[432];
        for (int i = 1; i <= 431; i++) {
            numbers[i] = new ArrayList<Prime_Count>();
            int temp = i;
            for (int j = 0; j < 83; j++) {
                int count = 0;
                while (temp % primes[j] == 0) {
                    count++;
                    temp /= primes[j];
                }
                if (count > 0) {
                    numbers[i].add(new Prime_Count(j, count));
                }
                if (temp == 1) {
                    break;
                }
            }
        }
        long results[][] = new long[432][432];
        for (int p = 0; p <= 431; p++) {
            for (int q = 0; q <= p / 2; q++) {
                int counts[] = new int[83];
                for (int i = p; i > p - q; i--) {
                    for (int j = 0; j < numbers[i].size(); j++) {
                        Prime_Count pc = numbers[i].get(j);
                        counts[pc.prime] += pc.count;
                    }
                }
                for (int i = 2; i <= q; i++) {
                    for (int j = 0; j < numbers[i].size(); j++) {
                        Prime_Count pc = numbers[i].get(j);
                        counts[pc.prime] -= pc.count;
                    }
                }
                results[p][q] = 1;
                for (int i = 0; i < 83; i++) {
                    results[p][q] *= counts[i] + 1;
                }
            }
        }
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int n = in.nextInt();
            int K = in.nextInt();
            K = Math.min(K, n - K);
            System.out.println(results[n][K]);
        }
    }
}

class Prime_Count {
    int prime;
    int count;

    public Prime_Count(int thePrime, int theCount) {
        this.prime = thePrime;
        this.count = theCount;
    }
}