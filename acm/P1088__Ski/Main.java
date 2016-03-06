package P1088__Ski;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int R = cin.nextInt();
        int C = cin.nextInt();
        Point points[][] = new Point[R][C];
        Position positions[] = new Position[R * C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int temp = cin.nextInt();
                points[i][j] = new Point(temp, 1);
                positions[i * C + j] = new Position(i, j, temp);
            }
        }
        Arrays.sort(positions);
        int max = 1;
        int offsetX[] = {
            -1, 0, 1, 0};
        int offsetY[] = {
            0, 1, 0, -1};
        for (int i = 0; i < R * C; i++) {
            int tempX = positions[i].x;
            int tempY = positions[i].y;
            int tempH = positions[i].height;
            boolean power = false;
            for (int j = 0; j < 4; j++) {
                int newX = tempX + offsetX[j];
                int newY = tempY + offsetY[j];
                if (newX >= 0 && newX < R && newY >= 0 && newY < C) {
                    if (points[newX][newY].height < tempH &&
                        points[tempX][tempY].length + 1 >
                        points[newX][newY].length) {
                        points[newX][newY].length = points[tempX][tempY].length +
                            1;
                        power = true;
                    }
                }
            }
            if (power == true && points[tempX][tempY].length + 1 > max) {
                max = points[tempX][tempY].length + 1;
            }
        }
        System.out.println(max);
    }
}

class Point {
    int height;
    int length;
    public Point(int theHeight, int theLength) {
        this.height = theHeight;
        this.length = theLength;
    }
}

class Position
    implements Comparable<Position> {
    int x;
    int y;
    int height;
    public Position(int X, int Y, int theHeight) {
        this.x = X;
        this.y = Y;
        this.height = theHeight;
    }

    public int compareTo(Position another) {
        return another.height - this.height;
    }
}
