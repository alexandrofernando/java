package P3282__Ferry_Loading_IV;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 4:16:32
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int L = in.nextInt() * 100;
            int m = in.nextInt();
            int left = 0;
            int right = 0;
            int leftCross = 0;
            int rightCross = 0;
            for (int i = 0; i < m; i++) {
                int length = in.nextInt();
                String str = in.next();
                if (str.equals("left") == true) {
                    if (left + length > L) {
                        left = length;
                        leftCross++;
                    } else {
                        left += length;
                    }
                } else {
                    if (right + length > L) {
                        right = length;
                        rightCross++;
                    } else {
                        right += length;
                    }
                }
            }
            if (left > 0) {
                leftCross++;
            }
            if (right > 0) {
                rightCross++;
            }
            if (leftCross >= rightCross - 1) {
                System.out.println(leftCross * 2 - 1);
            } else {
                System.out.println(rightCross * 2);
            }
        }
    }
}
