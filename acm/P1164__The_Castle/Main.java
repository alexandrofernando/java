package P1164__The_Castle;

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
    static Module modules[][];
    static int area;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        row = cin.nextInt();
        column = cin.nextInt();
        modules = new Module[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                modules[i][j] = new Module(cin.nextInt());
            }
        }
        int room = 0;
        int biggest = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (modules[i][j].used == false) {
                    area = 0;
                    search(i, j);
                    room++;
                    if (area > biggest) {
                        biggest = area;
                    }
                }
            }
        }
        System.out.println(room);
        System.out.println(biggest);
    }

    static void search(int r, int c) {
        if (modules[r][c].used == false) {
            modules[r][c].used = true;
            area++;
            if (modules[r][c].walls[0] == 0) {
                search(r, c - 1);
            }
            if (modules[r][c].walls[1] == 0) {
                search(r - 1, c);
            }
            if (modules[r][c].walls[2] == 0) {
                search(r, c + 1);
            }
            if (modules[r][c].walls[3] == 0) {
                search(r + 1, c);
            }
        }
    }
}

class Module {
    int walls[];
    boolean used;
    public Module(int number) {
        this.walls = new int[4];
        for (int i = 0; i < 4; i++) {
            this.walls[i] = number % 2;
            number /= 2;
        }
        this.used = false;
    }
}
