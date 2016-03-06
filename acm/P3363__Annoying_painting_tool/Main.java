package P3363__Annoying_painting_tool;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-13
 * Time: 16:57:45
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            int row = in.nextInt();
            int column = in.nextInt();
            if (n == 0 && m == 0 && row == 0 && column == 0) {
                break;
            }
            boolean picture[][] = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String str = in.next();
                for (int j = 0; j < m; j++) {
                    if (str.charAt(j) == '1') {
                        picture[i][j] = true;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < n - row + 1; i++) {
                for (int j = 0; j < m - column + 1; j++) {
                    if (picture[i][j] == true) {
                        for (int p = i; p < i + row; p++) {
                            for (int q = j; q < j + column; q++) {
                                picture[p][q] = !picture[p][q];
                            }
                        }
                        count++;
                    }
                }
                for (int j = m - column + 1; j < m; j++) {
                    if (picture[i][j] == true) {
                        count = -1;
                        break;
                    }
                }
                if (count == -1) {
                    break;
                }
            }
            if (count != -1) {
                for (int i = n - row + 1; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (picture[i][j] == true) {
                            count = -1;
                            break;
                        }
                    }
                    if (count == -1) {
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
