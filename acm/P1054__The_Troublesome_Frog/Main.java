package P1054__The_Troublesome_Frog;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
    static short paddy[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int R = cin.nextInt();
        int C = cin.nextInt();
        int N = cin.nextInt();
        Plant plants[] = new Plant[N];
        for (int i = 0; i < N; i++) {
            plants[i] = new Plant(cin.nextInt(), cin.nextInt());
        }
        Arrays.sort(plants);
        paddy = new short[R + 1][C + 1];
        for (int i = 0; i < N; i++) {
            paddy[plants[i].x][plants[i].y] = (short) (i + 1);
        }
        short matrix[][] = new short[N][];
        for (int i = 0; i < N; i++) {
            matrix[i] = new short[i];
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int tempX = plants[j].x * 2 - plants[i].x;
                int tempY = plants[j].y * 2 - plants[i].y;
                if (tempX < 1 || tempX > R || tempY < 1 || tempY > C) {
                    matrix[i][j] = 2;
                }
                else {
                    int tempIndex = paddy[tempX][tempY];
                    if (tempIndex != 0 && matrix[j][tempIndex - 1] != 0) {
                        matrix[i][j] = (short) (matrix[j][tempIndex - 1] + 1);
                        tempX = plants[i].x * 2 - plants[j].x;
                        tempY = plants[i].y * 2 - plants[j].y;
                        if (tempX < 1 || tempX > R || tempY < 1 || tempY > C) {
                            if (matrix[i][j] > max) {
                                max = matrix[i][j];
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}

class Plant
    implements Comparable<Plant> {
    int x;
    int y;
    public Plant(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public int compareTo(Plant another) {
        if (this.x != another.x) {
            return this.x - another.x;
        }
        else {
            return this.y - another.y;
        }
    }
}
