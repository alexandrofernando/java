package P2773__Happy_2006;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-19
 * Time: 6:52:34
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int m = in.nextInt();
            int K = in.nextInt();
            int euler = m;
            int temp = m;
            for (int i = 2; i * i <= temp; i++) {
                if (temp % i == 0) {
                    euler = euler / i * (i - 1);
                    while (temp % i == 0) {
                        temp /= i;
                    }
                }
            }
            if (temp != 1) {
                euler = euler / temp * (temp - 1);
            }
            int complete = (K - 1) / euler;
            int rest = (K - 1) % euler;
            int number = 0;
            for (int i = 0; i <= rest; i++) {
                do {
                    number++;
                } while (GCD(number, m) != 1);
            }
            number += complete * m;
            System.out.println(number);
        }
    }

    static int GCD(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
