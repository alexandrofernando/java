package P2282__The_Counting_Problem;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-15
 * Time: 17:19:48
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            int counts1[] = count(Math.min(a, b) - 1);
            int counts2[] = count(Math.max(a, b));
            for (int i = 0; i < 10; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(counts2[i] - counts1[i]);
            }
            System.out.println();
        }
    }

    static int[] count(int number) {
        int counts[] = new int[10];
        for (int i = 1; number >= i; i *= 10) {
            int front = number / i / 10;
            int rear = number % i;
            int digit = number / i % 10;
            for (int j = 0; j < 10; j++) {
                if (j * i > number) {
                    break;
                }
                if (j == 0 && i * 10 > number) {
                    continue;
                }
                if (j < digit) {
                    counts[j] += (front + 1) * i;
                } else if (j > digit) {
                    counts[j] += front * i;
                } else {
                    counts[j] += front * i + (rear + 1);
                }
                if (j == 0) {
                    counts[0] -= i;
                }
            }
        }
        return counts;
    }
}
