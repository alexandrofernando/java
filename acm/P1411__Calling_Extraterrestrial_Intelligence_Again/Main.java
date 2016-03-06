package P1411__Calling_Extraterrestrial_Intelligence_Again;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-5
 * Time: 0:15:42
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i <= 9999; i += 2) {
            if (isPrime(i) == true) {
                primes.add(i);
            }
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if (m == 0 && a == 0 && b == 0) {
                break;
            }
            int max = 0;
            int p = 0;
            int q = 0;
            for (int i = 0; i < primes.size(); i++) {
                int tempP = primes.get(i);
                if (tempP * tempP > m) {
                    break;
                }
                int top = tempP * b / a;
                if (top * tempP > m) {
                    top = m / tempP;
                }
                int index = Collections.binarySearch(primes, top);
                if (index < 0) {
                    index = -index - 2;
                }
                int tempQ = primes.get(index);
                if (tempP * tempQ > max) {
                    p = tempP;
                    q = tempQ;
                    max = tempP * tempQ;
                }
            }
            System.out.println(p + " " + q);
        }
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
