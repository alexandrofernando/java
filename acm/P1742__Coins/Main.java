package P1742__Coins;

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
        while (true) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            int A[] = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = cin.nextInt();
            }
            int C[] = new int[n];
            for (int i = 0; i < n; i++) {
                C[i] = cin.nextInt();
            }
            int max = 0;
            boolean pays[] = new boolean[m + 1];
            pays[0] = true;
            int lasts[] = new int[m + 1];
            for (int i = 0; i <= m; i++) {
                lasts[i] = -1;
            }
            int numbers[] = new int[m + 1];
            int result = 0;
            for (int i = 0; i < n; i++) {
                max += A[i] * C[i];
                if (max > m) {
                    max = m;
                }
                for (int j = A[i]; j <= max; j++) {
                    if (pays[j] == false) {
                        int previous = j - A[i];
                        if (pays[previous] == true) {
                            if (lasts[previous] == i &&
                                numbers[previous] == C[i]) {
                                continue;
                            }
                            lasts[j] = i;
                            if (lasts[previous] == i) {
                                numbers[j] = numbers[previous] + 1;
                            }
                            else {
                                numbers[j] = 1;
                            }
                            pays[j] = true;
                            result++;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
