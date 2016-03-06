package P2039__To_And_Fro;

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
        while (true) {
            int column = cin.nextInt();
            if (column == 0) {
                break;
            }
            String encrypted = cin.next();
            int length = encrypted.length();
            int row = length / column;
            char table[][] = new char[row][column];
            int pos = 0;
            for (int i = 0; i < table.length; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < column; j++) {
                        table[i][j] = encrypted.charAt(pos);
                        pos++;
                    }
                }
                else {
                    for (int j = column - 1; j >= 0; j--) {
                        table[i][j] = encrypted.charAt(pos);
                        pos++;
                    }
                }
            }
            for (int j = 0; j < column; j++) {
                for (int i = 0; i < row; i++) {
                    System.out.print(table[i][j]);
                }
            }
            System.out.println();
        }
    }
}
