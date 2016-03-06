package P2407__Relatives;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
    static int n;
    static ArrayList<Integer> primes;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            n = cin.nextInt();
            if (n == 0) {
                break;
            }
            int temp = n;
            primes = new ArrayList<Integer>();
            for (int i = 2; i * i <= n; i++) {
                if (temp == 1) {
                    break;
                }
                if (temp % i == 0) {
                    primes.add(i);
                    while (temp % i == 0) {
                        temp /= i;
                    }
                }
            }
            if (temp != 1) {
                primes.add(temp);
            }
            int result = n;
            for (int i = 1; i <= primes.size(); i++) {
                int part = select(0, 1, i);
                if (i % 2 == 0) {
                    result += part;
                } else {
                    result -= part;
                }
            }
            System.out.println(result);
        }
    }

    static int select(int index, int product, int m) {
        if (m == 0) {
            return n / product;
        } else if (index >= primes.size()) {
            return 0;
        } else {
            return select(index + 1, product, m) +
                    select(index + 1, product * primes.get(index), m - 1);
        }
    }
}
