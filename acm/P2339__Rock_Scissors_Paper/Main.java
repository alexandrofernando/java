package P2339__Rock_Scissors_Paper;

import java.util.Scanner;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-30
 * Time: 4:19:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            if (t != 1) {
                System.out.println();
            }
            int row = in.nextInt();
            int column = in.nextInt();
            int n = in.nextInt();
            char grid[][] = new char[row][column];
            for (int i = 0; i < row; i++) {
                String str = in.next();
                for (int j = 0; j < column; j++) {
                    grid[i][j] = str.charAt(j);
                }
            }
            int offsetX[] = {-1, 0, 1, 0};
            int offsetY[] = {0, 1, 0, -1};
            for (int day = 0; day < n; day++) {
                char newGrid[][] = new char[row][column];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        char previous = grid[i][j];
                        char possible;
                        if (previous == 'R') {
                            possible = 'P';
                        } else if (previous == 'S') {
                            possible = 'R';
                        } else {
                            possible = 'S';
                        }
                        boolean change = false;
                        for (int k = 0; k < 4; k++) {
                            int r = i + offsetX[k];
                            int c = j + offsetY[k];
                            if (r >= 0 && r < row && c >= 0 && c < column && grid[r][c] == possible) {
                                change = true;
                                break;
                            }
                        }
                        if (change == false) {
                            newGrid[i][j] = grid[i][j];
                        } else {
                            newGrid[i][j] = possible;
                        }
                    }
                }
                grid = newGrid;
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
        }
    }
}
