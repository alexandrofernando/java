package P3425__Customer_support;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-27
 * Time: 23:53:10
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int total = 0;
        int corrects[] = new int[1000001];
        for (int i = 0; i < N; i++) {
            int q = in.nextInt();
            int a = in.nextInt();
            int x = in.nextInt();
            if (a == 0) {
                total += 10;
            } else {
                total += corrects[q] * 10;
                if (x == 0) {
                    total += 20;
                } else {
                    total += 40;
                }
                corrects[q]++;
            }
        }
        System.out.println(total);
    }
}
