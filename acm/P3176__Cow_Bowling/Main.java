package P3176__Cow_Bowling;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-1
 * Time: 21:51:10
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int sum[] = new int[1];
        sum[0] = in.nextInt();
        for (int i = 1; i < N; i++) {
            int temp[] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                int current = in.nextInt();
                int t1 = Integer.MIN_VALUE;
                int t2 = Integer.MIN_VALUE;
                if (j != 0) {
                    t1 = sum[j - 1] + current;
                }
                if (j != i) {
                    t2 = sum[j] + current;
                }
                if (t1 > t2) {
                    temp[j] = t1;
                } else {
                    temp[j] = t2;
                }
            }
            sum = temp;
        }
        int max = Integer.MIN_VALUE;
        for (int aSum : sum) {
            if (aSum > max) {
                max = aSum;
            }
        }
        System.out.println(max);
    }
}
