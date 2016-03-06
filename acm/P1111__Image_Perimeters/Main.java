package P1111__Image_Perimeters;

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
    static int row;
    static int column;
    static char grids[][];
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            row = cin.nextInt();
            column = cin.nextInt();
            int clickX = cin.nextInt();
            int clickY = cin.nextInt();
            if (row == 0 && column == 0 && clickX == 0 && clickY == 0) {
                break;
            }
            clickX--;
            clickY--;
            grids = new char[row][column];
            for (int i = 0; i < row; i++) {
                String line = cin.next();
                for (int j = 0; j < column; j++) {
                    grids[i][j] = line.charAt(j);
                }
            }
            visited = new boolean[row][column];
            int perimeter = DFS(clickX, clickY, true);
            System.out.println(perimeter);
        }
        while (true);
    }

    static int DFS(int x, int y, boolean edge) {
        if (x >= 0 && x < row && y >= 0 && y < column && grids[x][y] == 'X') {
            if (visited[x][y] == true) {
                return 0;
            }
            else {
                visited[x][y] = true;
                int sum = 0;
                int offsetX[] = {
                    -1, -1, 0, 1, 1, 1, 0, -1};
                int offsetY[] = {
                    0, 1, 1, 1, 0, -1, -1, -1};
                boolean edges[] = {
                    true, false, true, false, true, false, true, false};
                for (int i = 0; i < 8; i++) {
                    sum += DFS(x + offsetX[i], y + offsetY[i], edges[i]);
                }
                return sum;
            }
        }
        else if (edge == true) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
