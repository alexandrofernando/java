package P3100__Root_Of_The_Problem;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            int B = cin.nextInt();
            int N = cin.nextInt();
            if (B == 0 && N == 0) {
                break;
            }
            if (N == 1) {
                System.out.println(B);
            }
            else {
                int preDiff = Integer.MAX_VALUE;
                int A = 1;
                while (true) {
                    int temp = 1;
                    for (int i = 0; i < N; i++) {
                        temp *= A;
                    }
                    int curDiff = Math.abs(temp - B);
                    if (curDiff > preDiff) {
                        System.out.println(A - 1);
                        break;
                    }
                    preDiff = curDiff;
                    A++;
                }
            }
        }
    }
}
