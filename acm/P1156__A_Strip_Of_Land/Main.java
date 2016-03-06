package P1156__A_Strip_Of_Land;

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
        int column = cin.nextInt();
        int row = cin.nextInt();
        int C = cin.nextInt();
        int heights[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                heights[i][j] = cin.nextInt() + 30001;
            }
        }
        int result = Integer.MIN_VALUE;
        for (int c1 = 0; c1 < column; c1++) {
            int index[] = new int[60002];
            int rmin[] = new int[row];
            int rmax[] = new int[row];
            for (int i = 0; i < row; i++) {
                rmin[i] = heights[i][c1];
                rmax[i] = heights[i][c1];
            }
            for (int c2 = c1; c2 < column && c2 - c1 < 100; c2++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int r1 = 0;
                for (int r2 = 0; r2 < row; r2++) {
                    if (heights[r2][c2] < rmin[r2]) {
                        rmin[r2] = heights[r2][c2];
                    }
                    if (heights[r2][c2] > rmax[r2]) {
                        rmax[r2] = heights[r2][c2];
                    }
                    if (rmax[r2] - rmin[r2] > C) {
                        r1 = r2 + 1;
                        continue;
                    }
                    if (rmax[r2] - min > C) {
                        for (int i = min; i < rmax[r2] - C && i <= max; i++) {
                            if (index[i] >= r1 && index[i] <= r2 &&
                                rmin[index[i]] == i) {
                                r1 = index[i] + 1;
                            }
                        }
                        min = Integer.MAX_VALUE;
                        for (int i = rmax[r2] - C; i <= rmax[r2]; i++) {
                            if (index[i] >= r1 && index[i] <= r2 &&
                                rmin[index[i]] == i) {
                                min = i;
                                break;
                            }
                        }
                    }
                    if (max - rmin[r2] > C) {
                        for (int i = max; i > rmin[r2] + C && i >= min; i--) {
                            if (index[i] >= r1 && index[i] <= r2 &&
                                rmax[index[i]] == i) {
                                r1 = index[i] + 1;
                            }
                        }
                        max = Integer.MIN_VALUE;
                        for (int i = rmin[r2] + C; i >= rmin[r2]; i--) {
                            if (index[i] >= r1 && index[i] <= r2 &&
                                rmax[index[i]] == i) {
                                max = i;
                                break;
                            }
                        }
                    }
                    if (rmin[r2] < min) {
                        min = rmin[r2];
                    }
                    if (rmax[r2] > max) {
                        max = rmax[r2];
                    }
                    index[rmin[r2]] = r2;
                    index[rmax[r2]] = r2;
                    int area = (c2 - c1 + 1) * (r2 - r1 + 1);
                    if (area > result) {
                        result = area;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
