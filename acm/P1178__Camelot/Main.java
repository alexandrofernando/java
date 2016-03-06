package P1178__Camelot;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

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
        int distances[][][][] = new int[8][8][8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int p = 0; p < 8; p++) {
                    for (int q = 0; q < 8; q++) {
                        distances[i][j][p][q] = -1;
                    }
                }
                LinkedList<Coordinate_Step>
                    queue = new LinkedList<Coordinate_Step> ();
                queue.offer(new Coordinate_Step(i, j, 0));
                distances[i][j][i][j] = 0;
                int offsetX[] = {
                    -2, -1, 1, 2, 2, 1, -1, -2};
                int offsetY[] = {
                    1, 2, 2, 1, -1, -2, -2, -1};
                while (queue.isEmpty() == false) {
                    Coordinate_Step head = queue.poll();
                    for (int k = 0; k < 8; k++) {
                        int newX = head.x + offsetX[k];
                        int newY = head.y + offsetY[k];
                        if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8 &&
                            distances[i][j][newX][newY] == -1) {
                            distances[i][j][newX][newY] = head.step + 1;
                            queue.offer(new Coordinate_Step(newX, newY,
                                head.step + 1));
                        }
                    }
                }
            }
        }

        String str = cin.next();
        CostMatrix king = new CostMatrix();
        int x = str.charAt(0) - 'A';
        int y = str.charAt(1) - '1';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                king.matrix[i][j] = Math.max(Math.abs(i - x), Math.abs(j - y));
            }
        }
        int knightNumber = (str.length() - 2) / 2;
        CostMatrix knights[] = new CostMatrix[knightNumber];
        for (int i = 0; i < knightNumber; i++) {
            x = str.charAt(i * 2 + 2) - 'A';
            y = str.charAt(i * 2 + 3) - '1';
            knights[i] = new CostMatrix();
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    knights[i].matrix[j][k] = distances[x][y][j][k];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < knightNumber; i++) {
            CostMatrix C = CostMatrix.add(king, knights[i]);
            CostMatrix total = new CostMatrix();
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    total.matrix[j][k] = Integer.MAX_VALUE;
                }
            }
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int p = 0; p < 8; p++) {
                        for (int q = 0; q < 8; q++) {
                            if (C.matrix[j][k] + distances[j][k][p][q] <
                                total.matrix[p][q]) {
                                total.matrix[p][q] = C.matrix[j][k] +
                                    distances[j][k][p][q];
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < knightNumber; j++) {
                if (j != i) {
                    total = CostMatrix.add(total, knights[j]);
                }
            }
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (total.matrix[j][k] < result) {
                        result = total.matrix[j][k];
                    }
                }
            }
        }
        System.out.println(result);
    }
}

class CostMatrix {
    int matrix[][];
    public CostMatrix() {
        this.matrix = new int[8][8];
    }

    static CostMatrix add(CostMatrix a, CostMatrix b) {
        CostMatrix c = new CostMatrix();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                c.matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        return c;
    }
}

class Coordinate_Step {
    int x;
    int y;
    int step;
    public Coordinate_Step(int X, int Y, int theStep) {
        this.x = X;
        this.y = Y;
        this.step = theStep;
    }
}
