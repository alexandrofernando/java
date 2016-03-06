package P1084__Square_Destroyer;

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
    static int n;
    static boolean matchsticks[];
    static int min;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            n = cin.nextInt();
            matchsticks = new boolean[2 * n * (n + 1) + 1];
            for (int i = 1; i < matchsticks.length; i++) {
                matchsticks[i] = true;
            }
            int m = cin.nextInt();
            for (int i = 0; i < m; i++) {
                matchsticks[cin.nextInt()] = false;
            }
            min = 60;
            destroy(0);
            System.out.println(min);
        }
    }

    static void destroy(int depth) {
        if (depth >= min) {
            return;
        }
        int count[] = evaluate();
        int max = 0;
        for (int i = 1; i < matchsticks.length; i++) {
            if (matchsticks[i] == true && count[i] > max) {
                max = count[i];
            }
        }
        if (max == 0) {
            min = depth;
        }
        int min = 60;
        for (int i = 1; i < matchsticks.length; i++) {
            if (matchsticks[i] == true && count[i] == max) {
                matchsticks[i] = false;
                destroy(depth + 1);
                matchsticks[i] = true;
            }
        }
    }

    static int[] evaluate() {
        int array[] = new int[matchsticks.length];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                for (int k = 1; k <= n - i + 1; k++) {
                    int index[] = {
                        (j - 1) * (n * 2 + 1) + k,
                        (j - 1) * (n * 2 + 1) + n + k,
                        (j + i - 1) * (n * 2 + 1) + k,
                        (j - 1) * (n * 2 + 1) + n + i + k};
                    int offset[] = {
                        1, n * 2 + 1, 1, n * 2 + 1};
                    boolean power = true;
                    for (int p = 0; p < 4; p++) {
                        int temp = index[p];
                        for (int q = 0; q < i; q++) {
                            if (matchsticks[temp] == false) {
                                power = false;
                                break;
                            }
                            temp += offset[p];
                        }
                        if (power == false) {
                            break;
                        }
                    }
                    if (power == true) {
                        for (int p = 0; p < 4; p++) {
                            int temp = index[p];
                            for (int q = 0; q < i; q++) {
                                array[temp]++;
                                temp += offset[p];
                            }
                        }
                    }
                }
            }
        }
        return array;
    }
}
