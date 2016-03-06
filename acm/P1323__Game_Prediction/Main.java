package P1323__Game_Prediction;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
    static boolean used[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        while (true) {
            int m = cin.nextInt();
            int n = cin.nextInt();
            if (m == 0 && n == 0) {
                break;
            }
            int cards[] = new int[n];
            used = new boolean[m * n + 1];
            for (int i = 0; i < n; i++) {
                cards[i] = cin.nextInt();
                used[cards[i]] = true;
            }
            Arrays.sort(cards);
            int min = 1;
            int max = m * n;
            int win = 0;
            for (int i = n - 1; i >= 0; i--) {
                max = previous(max);
                if (max > cards[i]) {
                    used[max] = true;
                    for (int j = 0; j < m - 2; j++) {
                        min = next(min);
                        used[min] = true;
                    }
                } else {
                    for (int j = 0; j < m - 1; j++) {
                        min = next(min);
                        used[min] = true;
                    }
                    win++;
                }
            }
            System.out.println("Case " + test + ": " + win);
            test++;
        }
    }

    static int next(int card) {
        while (used[card] == true) {
            card++;
        }
        return card;
    }

    static int previous(int card) {
        while (used[card] == true) {
            card--;
        }
        return card;
    }
}
