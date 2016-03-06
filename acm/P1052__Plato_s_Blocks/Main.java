package P1052__Plato_s_Blocks;

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
    static boolean pattern[][][];
    static int n;
    static boolean cube[][][];
    static int number;
    static int count;
    static boolean visit[][][];
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        n = cin.nextInt();
        while (n != 0) {
            pattern = new boolean[3][n][n];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    String temp = cin.next();
                    for (int k = 0; k < n; k++) {
                        if (temp.charAt(k) == 'X') {
                            pattern[i][j][k] = true;
                        }
                        else {
                            pattern[i][j][k] = false;
                        }
                    }
                }
            }
            boolean possible = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        cube = new boolean[n][n][n];
                        number = 0;
                        for (int a = 0; a < n; a++) {
                            for (int b = 0; b < n; b++) {
                                for (int c = 0; c < n; c++) {
                                    if (pattern[0][b][c] == true &&
                                        pattern[1][a][c] == true &&
                                        pattern[2][a][b] == true) {
                                        cube[a][b][c] = true;
                                        number++;
                                    }
                                    else {
                                        cube[a][b][c] = false;
                                    }
                                }
                            }
                        }
                        boolean consistent = true;
                        for (int b = 0; b < n; b++) {
                            for (int c = 0; c < n; c++) {
                                if (pattern[0][b][c] == true) {
                                    consistent = false;
                                    for (int a = 0; a < n; a++) {
                                        if (cube[a][b][c] == true) {
                                            consistent = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (consistent == false) {
                                break;
                            }
                        }
                        if (consistent == true) {
                            for (int a = 0; a < n; a++) {
                                for (int c = 0; c < n; c++) {
                                    if (pattern[1][a][c] == true) {
                                        consistent = false;
                                        for (int b = 0; b < n; b++) {
                                            if (cube[a][b][c] == true) {
                                                consistent = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (consistent == false) {
                                    break;
                                }
                            }
                        }
                        if (consistent == true) {
                            for (int a = 0; a < n; a++) {
                                for (int b = 0; b < n; b++) {
                                    if (pattern[2][a][b] == true) {
                                        consistent = false;
                                        for (int c = 0; c < n; c++) {
                                            if (cube[a][b][c] == true) {
                                                consistent = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (consistent == false) {
                                    break;
                                }
                            }
                        }
                        if (consistent == true && isConnect() == true) {
                            possible = true;
                            break;
                        }
                        rotate(2);
                    }
                    if (possible == true) {
                        break;
                    }
                    rotate(1);
                }
                if (possible == true) {
                    break;
                }
                rotate(0);
            }
            System.out.print("Data set " + test + ": ");
            test++;
            if (possible == true) {
                System.out.println("Valid set of patterns");
            }
            else {
                System.out.println("Impossible combination");
            }
            n = cin.nextInt();
        }
    }

    public static void rotate(int index) {
        boolean copy[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = pattern[index][i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pattern[index][i][j] = copy[j][n - i - 1];
            }
        }
    }

    public static boolean isConnect() {
        visit = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (cube[i][j][k] == true) {
                        count = 1;
                        visit[i][j][k] = true;
                        DFS(i, j, k);
                        if (count == number) {
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void DFS(int a, int b, int c) {
        if (a > 0 && cube[a - 1][b][c] == true && visit[a - 1][b][c] == false) {
            visit[a - 1][b][c] = true;
            count++;
            DFS(a - 1, b, c);
        }
        if (a < n - 1 && cube[a + 1][b][c] == true && visit[a + 1][b][c] == false) {
            visit[a + 1][b][c] = true;
            count++;
            DFS(a + 1, b, c);
        }
        if (b > 0 && cube[a][b - 1][c] == true && visit[a][b - 1][c] == false) {
            visit[a][b - 1][c] = true;
            count++;
            DFS(a, b - 1, c);
        }
        if (b < n - 1 && cube[a][b + 1][c] == true && visit[a][b + 1][c] == false) {
            visit[a][b + 1][c] = true;
            count++;
            DFS(a, b + 1, c);
        }
        if (c > 0 && cube[a][b][c - 1] == true && visit[a][b][c - 1] == false) {
            visit[a][b][c - 1] = true;
            count++;
            DFS(a, b, c - 1);
        }
        if (c < n - 1 && cube[a][b][c + 1] == true && visit[a][b][c + 1] == false) {
            visit[a][b][c + 1] = true;
            count++;
            DFS(a, b, c + 1);
        }
    }
}
