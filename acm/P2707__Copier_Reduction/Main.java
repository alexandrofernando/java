package P2707__Copier_Reduction;

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
            int A = cin.nextInt();
            int B = cin.nextInt();
            int C = cin.nextInt();
            int D = cin.nextInt();
            if (A == 0 && B == 0 && C == 0 && D == 0) {
                break;
            }
            int temp1 = Math.min(ratio(A, C), ratio(B, D));
            int temp2 = Math.min(ratio(A, D), ratio(B, C));
            int result = Math.max(temp1, temp2);
            System.out.println(result + "%");
        }
    }

    static int ratio(int a, int b) {
        if (a <= b) {
            return 100;
        } else {
            return (int) Math.floor(b * 100.0 / a);
        }
    }
}
