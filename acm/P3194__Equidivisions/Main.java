package P3194__Equidivisions;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-15
 * Time: 5:18:43
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int cells[][] = new int[n][n];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = in.nextInt() - 1;
                    int y = in.nextInt() - 1;
                    cells[x][y] = i;
                }
            }
            boolean good = true;
            int offsetX[] = {-1, 0, 1, 0};
            int offsetY[] = {0, 1, 0, -1};
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean power = false;
                    for (int k = 0; k < 4; k++) {
                        int tempX = i + offsetX[k];
                        int tempY = j + offsetY[k];
                        if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n && cells[i][j] == cells[tempX][tempY]) {
                            power = true;
                            break;
                        }
                    }
                    if (power == false) {
                        good = false;
                        break;
                    }
                }
                if (good == false) {
                    break;
                }
            }
            if (good == true || n == 1) {
                System.out.println("good");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
