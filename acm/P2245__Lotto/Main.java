package P2245__Lotto;

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
    static int K;
    static int numbers[];
    static boolean used[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            K = cin.nextInt();
            if (K == 0) {
                break;
            }
            numbers = new int[K];
            used = new boolean[K];
            for (int i = 0; i < K; i++) {
                numbers[i] = cin.nextInt();
            }
            search(0, 0);
            System.out.println();
        }
    }

    static void search(int index, int finish) {
        if (index == K) {
            boolean first = true;
            for (int i = 0; i < K; i++) {
                if (used[i] == true) {
                    if (first == true) {
                        first = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(numbers[i]);
                }
            }
            System.out.println();
        } else {
            if (finish < 6) {
                used[index] = true;
                search(index + 1, finish + 1);
                used[index] = false;
            }
            if (K - index > 6 - finish) {
                search(index + 1, finish);
            }
        }
    }
}
