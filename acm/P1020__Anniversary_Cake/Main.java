package P1020__Anniversary_Cake;

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
    static int s;
    static int n;
    static int size[];
    static boolean used[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            s = cin.nextInt();
            n = cin.nextInt();
            size = new int[11];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int temp = cin.nextInt();
                sum += temp * temp;
                size[temp]++;
            }
            boolean can = true;
            if (s * s != sum) {
                can = false;
            }
            else {
                used = new boolean[s][s];
                if (search(0) == false) {
                    can = false;
                }
            }
            if (can == true) {
                System.out.println("KHOOOOB!");
            }
            else {
                System.out.println("HUTUTU!");
            }
        }
    }

    static boolean search(int depth) {
        if (depth == n) {
            return true;
        }
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (used[i][j] == false) {
                    for (int k = 10; k >= 1; k--) {
                        if (size[k] > 0 && i + k <= s && j + k <= s) {
                            boolean power = true;
                            for (int p = i; p < i + k; p++) {
                                for (int q = j; q < j + k; q++) {
                                    if (used[p][q] == true) {
                                        power = false;
                                        break;
                                    }
                                }
                                if (power == false) {
                                    break;
                                }
                            }
                            if (power == true) {
                                for (int p = i; p < i + k; p++) {
                                    for (int q = j; q < j + k; q++) {
                                        used[p][q] = true;
                                    }
                                }
                                size[k]--;
                                if (search(depth + 1) == true) {
                                    return true;
                                }
                                size[k]++;
                                for (int p = i; p < i + k; p++) {
                                    for (int q = j; q < j + k; q++) {
                                        used[p][q] = false;
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
