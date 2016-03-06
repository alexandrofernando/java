package P3652__Persistent_Bits;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-16
 * Time: 8:06:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int A = in.nextInt();
            if (A == 0) {
                break;
            }
            int B = in.nextInt();
            int C = in.nextInt();
            int S = in.nextInt();
            boolean visited[] = new boolean[65536];
            boolean bits[][] = new boolean[16][2];
            int number = S;
            while (!visited[number]) {
                visited[number] = true;
                int value = number;
                for (int i = 15; i >= 0; i--) {
                    bits[i][value % 2] = true;
                    value /= 2;
                }
                number = (A * number + B) % C;
            }
            for (int i = 0; i < 16; i++) {
                if (bits[i][0] && bits[i][1]) {
                    System.out.print("?");
                } else if (bits[i][0]) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
}
