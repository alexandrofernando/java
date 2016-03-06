package P1104__Robbery;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
    static int W;
    static int H;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        do {
            W = cin.nextInt();
            H = cin.nextInt();
            int T = cin.nextInt();
            if (W == 0 && H == 0 && T == 0) {
                break;
            }
            boolean possibles[][][] = new boolean[T + 1][W + 1][H + 1];
            for (int i = 1; i <= T; i++) {
                for (int j = 1; j <= W; j++) {
                    for (int k = 1; k <= H; k++) {
                        possibles[i][j][k] = true;
                    }
                }
            }
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                int time = cin.nextInt();
                int minX = cin.nextInt();
                int minY = cin.nextInt();
                int maxX = cin.nextInt();
                int maxY = cin.nextInt();
                for (int j = minX; j <= maxX; j++) {
                    for (int k = minY; k <= maxY; k++) {
                        possibles[time][j][k] = false;
                    }
                }
            }
            for (int i = 1; i < T; i++) {
                boolean temp[][] = afterMove(possibles[i]);
                intersect(possibles[i + 1], temp);
            }
            for (int i = T; i > 1; i--) {
                boolean temp[][] = afterMove(possibles[i]);
                intersect(possibles[i - 1], temp);
            }
            System.out.println("Robbery #" + test + ":");
            test++;
            boolean escaped = false;
            ArrayList<Conclution> conclutions = new ArrayList<Conclution> ();
            for (int i = 1; i <= T; i++) {
                int count = 0;
                int tempX = 0;
                int tempY = 0;
                for (int j = 1; j <= W; j++) {
                    for (int k = 1; k <= H; k++) {
                        if (possibles[i][j][k] == true) {
                            tempX = j;
                            tempY = k;
                            count++;
                        }
                        if (count == 2) {
                            break;
                        }
                    }
                    if (count == 2) {
                        break;
                    }
                }
                if (count == 0) {
                    escaped = true;
                    break;
                }
                else if (count == 1) {
                    conclutions.add(new Conclution(i, tempX, tempY));
                }
            }
            if (escaped == true) {
                System.out.println("The robber has escaped.");
            }
            else if (conclutions.size() == 0) {
                System.out.println("Nothing known.");
            }
            else {
                for (int i = 0; i < conclutions.size(); i++) {
                    Conclution one = conclutions.get(i);
                    System.out.println("Time step " + one.time +
                                       ": The robber has been at " + one.x +
                                       "," + one.y + ".");
                }
            }
            System.out.println();
        }
        while (true);
    }

    static boolean[][] afterMove(boolean origin[][]) {
        boolean moved[][] = new boolean[W + 1][H + 1];
        int offsetX[] = {
            0, -1, 0, 1, 0};
        int offsetY[] = {
            0, 0, 1, 0, -1};
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= H; j++) {
                if (origin[i][j] == true) {
                    for (int k = 0; k < 5; k++) {
                        int tempX = i + offsetX[k];
                        int tempY = j + offsetY[k];
                        if (tempX >= 1 && tempX <= W && tempY >= 1 &&
                            tempY <= H) {
                            moved[tempX][tempY] = true;
                        }
                    }
                }
            }
        }
        return moved;
    }

    static void intersect(boolean a[][], boolean b[][]) {
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= H; j++) {
                a[i][j] = a[i][j] && b[i][j];
            }
        }
    }
}

class Conclution {
    int time;
    int x;
    int y;
    public Conclution(int theTime, int X, int Y) {
        this.time = theTime;
        this.x = X;
        this.y = Y;
    }
}
