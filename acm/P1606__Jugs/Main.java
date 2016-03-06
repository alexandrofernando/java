package P1606__Jugs;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-16
 * Time: 22:28:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int Ca = in.nextInt();
            int Cb = in.nextInt();
            int N = in.nextInt();
            int a = 0;
            int b;
            while (true) {
                b = Cb;
                System.out.println("fill B");
                if (b == N) {
                    break;
                }
                while (b >= Ca) {
                    b -= Ca - a;
                    a = Ca;
                    System.out.println("pour B A");
                    if (b == N) {
                        break;
                    }
                    a = 0;
                    System.out.println("empty A");
                }
                if (b == N) {
                    break;
                }
                a = b;
                b = 0;
                System.out.println("pour B A");
            }
            System.out.println("success");
        }
    }
}
