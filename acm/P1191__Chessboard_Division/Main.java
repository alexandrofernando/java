package P1191__Chessboard_Division;

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
    static int sums[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        int scores[][] = new int[8][8];
        double average = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                scores[i][j] = cin.nextInt();
                average += scores[i][j];
            }
        }
        average /= n;
        sums = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sums[i][j] = scores[i][j];
                if (i > 0) {
                    sums[i][j] += sums[i - 1][j];
                }
                if (j > 0) {
                    sums[i][j] += sums[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sums[i][j] -= sums[i - 1][j - 1];
                }
            }
        }
        int d[][][][][] = new int[n + 1][9][9][9][9];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int p = 0; p < 9; p++) {
                        for (int q = 0; q < 9; q++) {
                            d[i][j][k][p][q] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int p = i; p < 8; p++) {
                    for (int q = j; q < 8; q++) {
                        d[1][i][j][p][q] = partialSquare(i, j, p, q);
                    }
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int p = j; p < 8; p++) {
                        for (int q = k; q < 8; q++) {
                            d[i][j][k][p][q] = Integer.MAX_VALUE;
                            for (int r = j; r <= p; r++) {
                                int temp1 = partialSquare(j, k, r, q);
                                int temp2 = d[i - 1][r + 1][k][p][q];
                                if (temp1 != -1 && temp2 != Integer.MAX_VALUE &&
                                    temp1 + temp2 < d[i][j][k][p][q]) {
                                    d[i][j][k][p][q] = temp1 + temp2;
                                }
                                temp1 = d[i - 1][j][k][r][q];
                                temp2 = partialSquare(r + 1, k, p, q);
                                if (temp1 != Integer.MAX_VALUE && temp2 != -1 &&
                                    temp1 + temp2 < d[i][j][k][p][q]) {
                                    d[i][j][k][p][q] = temp1 + temp2;
                                }
                            }
                            for (int r = k; r <= q; r++) {
                                int temp1 = partialSquare(j, k, p, r);
                                int temp2 = d[i - 1][j][r + 1][p][q];
                                if (temp1 != -1 && temp2 != Integer.MAX_VALUE &&
                                    temp1 + temp2 < d[i][j][k][p][q]) {
                                    d[i][j][k][p][q] = temp1 + temp2;
                                }
                                temp1 = d[i - 1][j][k][p][r];
                                temp2 = partialSquare(j, r + 1, p, q);
                                if (temp1 != Integer.MAX_VALUE && temp2 != -1 &&
                                    temp1 + temp2 < d[i][j][k][p][q]) {
                                    d[i][j][k][p][q] = temp1 + temp2;
                                }
                            }
                        }
                    }
                }
            }
        }
        double result = Math.sqrt( (double) d[n][0][0][7][7] / n -
                                  average * average);
        System.out.printf("%.3f\n", result);
    }

    static int partialSquare(int x0, int y0, int x1, int y1) {
        if (x0 <= x1 && y0 <= y1) {
            int temp = sums[x1][y1];
            if (x0 > 0) {
                temp -= sums[x0 - 1][y1];
            }
            if (y0 > 0) {
                temp -= sums[x1][y0 - 1];
            }
            if (x0 > 0 && y0 > 0) {
                temp += sums[x0 - 1][y0 - 1];
            }
            return temp * temp;
        }
        else {
            return -1;
        }
    }
}
