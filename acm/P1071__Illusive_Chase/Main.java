package P1071__Illusive_Chase;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int m = cin.nextInt();
            int n = cin.nextInt();
            int grid[][] = new int[m][n];
            boolean start[][] = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = cin.nextInt();
                    if (grid[i][j] == 0) {
                        start[i][j] = true;
                    }
                }
            }
            ArrayList steps = new ArrayList<Step> ();
            int tempMin, tempMax;
            while ( (tempMin = cin.nextInt()) != 0 |
                   (tempMax = cin.nextInt()) != 0) {
                steps.add(new Step(tempMin, tempMax, cin.next()));
            }
            for (int s = steps.size() - 1; s >= 0; s--) {
                int min = ( (Step) steps.get(s)).min;
                int max = ( (Step) steps.get(s)).max;
                String direction = ( (Step) steps.get(s)).direction;
                boolean temp[][] = new boolean[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (start[i][j] == true) {
                            Point point = new Point(i, j, m, n);
                            for (int k = 1; k <= max; k++) {
                                if (point.change(direction) == false ||
                                    grid[point.x][point.y] == 1) {
                                    break;
                                }
                                if (k >= min) {
                                    temp[point.x][point.y] = true;
                                }
                            }
                        }
                    }
                }
                start = temp.clone();
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (start[i][j] == true) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

class Point {
    int x;
    int y;
    int row;
    int column;
    public Point(int X, int Y, int theRow, int theColumn) {
        this.x = X;
        this.y = Y;
        this.row = theRow;
        this.column = theColumn;
    }

    public boolean change(String direction) {
        if (direction.equals("U") == true) {
            this.x++;
            if (this.x >= row) {
                return false;
            }
            else {
                return true;
            }
        }
        else if (direction.equals("R") == true) {
            this.y--;
            if (this.y < 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else if (direction.equals("D") == true) {
            this.x--;
            if (this.x < 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else if (direction.equals("L") == true) {
            this.y++;
            if (this.y >= column) {
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

class Step {
    int min;
    int max;
    String direction;
    public Step(int theMin, int theMax, String theDirection) {
        this.min = theMin;
        this.max = theMax;
        this.direction = theDirection;
    }
}
