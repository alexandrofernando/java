package P2665__Trees;

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
        do {
            int L = cin.nextInt();
            int M = cin.nextInt();
            if (L == 0 && M == 0) {
                break;
            }
            int left = L + 1;
            for (int i = 0; i < M; i++) {
                int start = cin.nextInt();
                int end = cin.nextInt();
                left -= (end - start + 1);
            }
            System.out.println(left);
        }
        while (true);
    }
}
