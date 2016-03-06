package P3070__Fibonacci;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-28
 * Time: 6:50:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == -1) {
                break;
            }
            n %= 15000;
            if (n == 0 || n == 1) {
                System.out.println(n);
            } else {
                int f0 = 0;
                int f1 = 1;
                for (int i = 0; i < n - 1; i++) {
                    int f2 = (f0 + f1) % 10000;
                    f0 = f1;
                    f1 = f2;
                }
                System.out.println(f1);
            }
        }
    }
}
