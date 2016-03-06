package P2083__Fractal;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-7
 * Time: 18:39:23
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static char fractal[][];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == -1) {
                break;
            }
            int size = 1;
            for (int i = 0; i < n - 1; i++) {
                size *= 3;
            }
            fractal = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    fractal[i][j] = ' ';
                }
            }
            box(size, 0, 0);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(fractal[i][j]);
                }
                System.out.println();
            }
            System.out.println("-");
        }
    }

    static void box(int size, int x, int y) {
        if (size == 1) {
            fractal[x][y] = 'X';
        } else {
            box(size / 3, x, y);
            box(size / 3, x, y + size / 3 * 2);
            box(size / 3, x + size / 3, y + size / 3);
            box(size / 3, x + size / 3 * 2, y);
            box(size / 3, x + size / 3 * 2, y + size / 3 * 2);
        }
    }
}
