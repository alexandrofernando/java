package P2126__Factoring_a_Polynomial;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-24
 * Time: 2:06:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 2) {
            System.out.println("YES");
        } else if (n == 2) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (b * b - 4 * a * c >= 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } else {
            System.out.println("NO");
        }
    }
}
