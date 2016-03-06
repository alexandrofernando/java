package P3325__ICPC_Score_Totalizer_Software;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-16
 * Time: 22:49:51
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                sum += s;
                if (s < min) {
                    min = s;
                }
                if (s > max) {
                    max = s;
                }
            }
            System.out.println((sum - min - max) / (n - 2));
        }
    }
}
