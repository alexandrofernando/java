package P2085__Inversion;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-14
 * Time: 1:29:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == -1 && m == -1) {
                break;
            }
            int last = 1;
            while (last * (last - 1) / 2 < m) {
                last++;
            }
            last--;
            boolean first = true;
            for (int i = 1; i <= n - last - 1; i++) {
                if (first == false) {
                    System.out.print(" ");
                } else {
                    first = false;
                }
                System.out.print(i);
            }
            int offset = m - last * (last - 1) / 2;
            if (first == false) {
                System.out.print(" ");
            }
            System.out.print(offset + (n - last));
            for (int i = last - offset; i >= 1; i--) {
                int number = offset + (n - last) + i;
                System.out.print(" " + number);
            }
            for (int i = 1; i <= offset; i++) {
                int number = offset + (n - last) - i;
                System.out.print(" " + number);
            }
            System.out.println();
        }
    }
}
