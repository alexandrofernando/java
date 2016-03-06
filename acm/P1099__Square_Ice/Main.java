package P1099__Square_Ice;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        int m = cin.nextInt();
        while (m != 0) {
            H2O matrix[][] = new H2O[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = new H2O(cin.nextInt());
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j].entry == 0) {
                        if (i != 0 && matrix[i - 1][j].down == false) {
                            matrix[i][j].up = true;
                        }
                        else {
                            matrix[i][j].down = true;
                        }
                        if (j == 0 || matrix[i][j - 1].right == false) {
                            matrix[i][j].left = true;
                        }
                        else {
                            matrix[i][j].right = true;
                        }
                    }
                }
            }
            if (test != 1) {
                System.out.println();
            }
            System.out.println("Case " + test + ":");
            System.out.println();
            for (int i = 0; i < m * 4 - 1; i++) {
                for (int j = 0; j < m * 4 + 3; j++) {
                    if (i == 0 || i == m * 4 - 2 || j == 0 || j == m * 4 + 2) {
                        System.out.print("*");
                    }
                    else if (i % 4 == 1) {
                        if (j % 4 == 1) {
                            System.out.print("H");
                        }
                        else if (j % 4 == 3) {
                            System.out.print("O");
                        }
                        else if (j % 4 == 2) {
                            if (matrix[i / 4][j / 4].left == true) {
                                System.out.print("-");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        else if (j % 4 == 0) {
                            if (matrix[i / 4][j / 4 - 1].right == true) {
                                System.out.print("-");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                    }
                    else if (i % 4 == 2) {
                        if (j % 4 == 3 && matrix[i / 4][j / 4].down == true) {
                            System.out.print("|");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    else if (i % 4 == 3) {
                        if (j % 4 == 3) {
                            System.out.print("H");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    else if (i % 4 == 0) {
                        if (j % 4 == 3 && matrix[i / 4][j / 4].up == true) {
                            System.out.print("|");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
            m = cin.nextInt();
            test++;
        }
    }
}

class H2O {
    int entry;
    boolean up = false, down = false, left = false, right = false;
    public H2O(int theEntry) {
        this.entry = theEntry;
        if (theEntry == 1) {
            this.up = false;
            this.down = false;
            this.left = true;
            this.right = true;
        }
        else if (theEntry == -1) {
            this.up = true;
            this.down = true;
            this.left = false;
            this.right = false;
        }
    }
}
