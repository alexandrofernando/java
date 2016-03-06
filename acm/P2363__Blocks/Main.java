package P2363__Blocks;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            if (N == 0) {
                System.out.println(0);
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = 1; i <= N; i++) {
                    if (i * i > N) {
                        i = N;
                    }
                    if (N % i == 0) {
                        int rest = N / i;
                        for (int j = 1; j <= rest; j++) {
                            if (j * j > rest) {
                                j = rest;
                            }
                            if (rest % j == 0) {
                                int k = rest / j;
                                int need = (i * j + j * k + k * i) * 2;
                                if (need < min) {
                                    min = need;
                                }
                            }
                        }
                    }
                }
                System.out.println(min);
            }
        }
    }
}
