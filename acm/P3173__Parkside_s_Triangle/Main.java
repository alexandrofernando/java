package P3173__Parkside_s_Triangle;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-1
 * Time: 9:28:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            int temp = S;
            for (int j = i; j < N; j++) {
                if (j != i) {
                    System.out.print(" ");
                }
                System.out.print(temp);
                temp = (temp + j) % 9 + 1;
            }
            System.out.println();
            S = (S + i + 1) % 9 + 1;
        }
    }
}
