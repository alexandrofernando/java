package P1064__Cable_Master;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int K = cin.nextInt();
        int cables[] = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            cables[i] = (int) (cin.nextDouble() * 100);
            sum += cables[i];
        }
        long left = 0;
        long right = sum / K;
        while (left != right) {
            long mid = (right + left + 1) / 2;
            int count = 0;
            for (int i = 0; i < N; i++) {
                count += cables[i] / mid;
            }
            if (count >= K) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.printf("%.2f\n", left / 100.0);
    }
}
