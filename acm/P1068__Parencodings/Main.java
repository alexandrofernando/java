package P1068__Parencodings;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int length = cin.nextInt();
            int P[] = new int[length];
            for (int i = 0; i < P.length; i++) {
                P[i] = cin.nextInt();
            }
            int W[] = new int[length];
            for (int i = 0; i < P.length; i++) {
                int j;
                for (j = i - 1; j >= 0; j--) {
                    if (P[i] - P[j] >= i - j) {
                        break;
                    }
                }
                W[i] = i - j;
            }
            for (int i = 0; i < W.length; i++) {
                if (i == 0) {
                    System.out.print(W[0]);
                }
                else {
                    System.out.print(" " + W[i]);
                }
            }
            System.out.println();
        }
    }
}
