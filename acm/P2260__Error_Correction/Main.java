package P2260__Error_Correction;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            int matrix[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = cin.nextInt();
                }
            }
            int countRow = 0;
            int row = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += matrix[i][j];
                }
                if (sum % 2 == 1) {
                    row = i;
                    countRow++;
                }
            }
            int countColumn = 0;
            int column = 0;
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += matrix[i][j];
                }
                if (sum % 2 == 1) {
                    column = j;
                    countColumn++;
                }
            }
            if (countRow == 0 && countColumn == 0) {
                System.out.println("OK");
            } else if (countRow == 1 && countColumn == 1) {
                System.out.println("Change bit (" + (row + 1) + "," +
                                   (column + 1) + ")");
            } else {
                System.out.println("Corrupt");
            }
        }
    }
}
