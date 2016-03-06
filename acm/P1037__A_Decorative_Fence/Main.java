package P1037__A_Decorative_Fence;

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
        long count[][][] = new long[21][21][2];
        count[1][1][0] = 1;
        count[1][1][1] = 1;
        for (int i = 2; i < 21; i++) {
            for (int j = 1; j <= i; j++) {
                long sum = 0;
                for (int p = j; p <= i - 1; p++) {
                    sum += count[i - 1][p][1];
                }
                count[i][j][0] = sum;
                sum = 0;
                for (int p = 1; p < j; p++) {
                    sum += count[i - 1][p][0];
                }
                count[i][j][1] = sum;
            }
        }
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            long C = cin.nextLong();
            long current = 0;
            boolean used[] = new boolean[N + 1];
            boolean up = false;
            int length[] = new int[N];
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    for (int j = 1; j <= N; j++) {
                        if (current + count[N][j][1] < C) {
                            current += count[N][j][1];
                        }
                        else {
                            length[0] = j;
                            used[j] = true;
                            up = true;
                            break;
                        }
                        if (current + count[N][j][0] < C) {
                            current += count[N][j][0];
                        }
                        else {
                            length[0] = j;
                            used[j] = true;
                            up = false;
                            break;
                        }
                    }
                }
                else if (up == true) {
                    int pos = 1;
                    for (int j = 1; j < length[i - 1]; j++) {
                        if (used[j] == false) {
                            if (current + count[N - i][pos][0] < C) {
                                current += count[N - i][pos][0];
                                pos++;
                            }
                            else {
                                length[i] = j;
                                used[j] = true;
                                up = false;
                                break;
                            }
                        }
                    }
                }
                else if (up == false) {
                    int pos = 1;
                    for (int j = 1; j <= N; j++) {
                        if (used[j] == false) {
                            if (j < length[i - 1]) {
                                pos++;
                            }
                            else {
                                if (current + count[N - i][pos][1] < C) {
                                    current += count[N - i][pos][1];
                                    pos++;
                                }
                                else {
                                    length[i] = j;
                                    used[j] = true;
                                    up = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(length[i]);
            }
            System.out.println();
        }
    }
}
