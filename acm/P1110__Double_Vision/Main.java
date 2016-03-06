package P1110__Double_Vision;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        do {
            int n = cin.nextInt();
            int row = cin.nextInt();
            int column = cin.nextInt();
            if (n == 0 && row == 0 && column == 0) {
                break;
            }
            Symbol symbols[] = new Symbol[n];
            for (int i = 0; i < n; i++) {
                symbols[i] = new Symbol(row, column);
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < n; j++) {
                    String temp = cin.next();
                    for (int k = 0; k < column; k++) {
                        symbols[j].grids[i][k] = temp.charAt(k);
                    }
                }
            }
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                boolean find = false;
                for (int j = 0; j < row; j++) {
                    for (int k = 0; k < column; k++) {
                        if (symbols[i].grids[j][k] == 'o') {
                            boolean power = true;
                            for (int p = 0; p < n; p++) {
                                if (p == i) {
                                    continue;
                                }
                                if (symbols[p].grids[j][k] == 'o') {
                                    power = false;
                                    break;
                                }
                            }
                            if (power == true) {
                                symbols[i].idNumber = 1;
                                symbols[i].x0 = j;
                                symbols[i].y0 = k;
                                find = true;
                                break;
                            }
                        }
                    }
                    if (find == true) {
                        break;
                    }
                }
                if (find == false) {
                    for (int j = 0; j < row; j++) {
                        for (int k = 0; k < column; k++) {
                            if (symbols[i].grids[j][k] == 'o') {
                                for (int p = j; p < row; p++) {
                                    for (int q = (p == j ? k + 1 : 0);
                                         q < column; q++) {
                                        if (symbols[i].grids[p][q] == 'o') {
                                            boolean power = true;
                                            for (int s = 0; s < n; s++) {
                                                if (s == i) {
                                                    continue;
                                                }
                                                if (symbols[s].grids[j][k] ==
                                                    'o' &&
                                                    symbols[s].grids[p][q] ==
                                                    'o') {
                                                    power = false;
                                                    break;
                                                }
                                            }
                                            if (power == true) {
                                                symbols[i].idNumber = 2;
                                                symbols[i].x0 = j;
                                                symbols[i].y0 = k;
                                                symbols[i].x1 = p;
                                                symbols[i].y1 = q;
                                                find = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (find == true) {
                                        break;
                                    }
                                }
                                if (find == true) {
                                    break;
                                }
                            }
                        }
                        if (find == true) {
                            break;
                        }
                    }
                    if (find == false) {
                        possible = false;
                        break;
                    }
                }
            }
            System.out.println("Test " + test);
            test++;
            if (possible == false) {
                System.out.println("impossible");
            }
            else {
                for (int i = 0; i < n; i++) {
                    symbols[i].revise();
                }
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j != 0) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k < column; k++) {
                            System.out.print(symbols[j].grids[i][k]);
                        }
                    }
                    System.out.println();
                }
            }
        }
        while (true);
    }
}

class Symbol {
    char grids[][];
    int idNumber;
    int x0, y0, x1, y1;
    public Symbol(int r, int c) {
        this.grids = new char[r][c];
    }

    public void revise() {
        this.grids[this.x0][this.y0] = '#';
        if (this.idNumber == 2) {
            this.grids[this.x1][this.y1] = '#';
        }
    }
}
