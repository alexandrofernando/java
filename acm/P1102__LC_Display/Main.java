package P1102__LC_Display;

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
        do {
            int size = cin.nextInt();
            String str = cin.next();
            if (size == 0 && str.equals("0") == true) {
                break;
            }
            int length = str.length();
            char grids[][] = new char[size * 2 + 3][ (size + 2) * length +
                length - 1];
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    grids[i][j] = ' ';
                }
            }
            for (int i = 0; i < length; i++) {
                char ch = str.charAt(i);
                for (int j = 1; j <= size; j++) {
                    if (ch == '0' || ch == '2' || ch == '3' || ch == '5' ||
                        ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                        grids[0][ (size + 3) * i + j] = '-';
                    }
                    if (ch == '2' || ch == '3' || ch == '4' || ch == '5' ||
                        ch == '6' || ch == '8' || ch == '9') {
                        grids[size + 1][ (size + 3) * i + j] = '-';
                    }
                    if (ch == '0' || ch == '2' || ch == '3' || ch == '5' ||
                        ch == '6' || ch == '8' || ch == '9') {
                        grids[size * 2 + 2][ (size + 3) * i + j] = '-';
                    }
                    if (ch == '0' || ch == '4' || ch == '5' || ch == '6' ||
                        ch == '8' || ch == '9') {
                        grids[j][ (size + 3) * i] = '|';
                    }
                    if (ch == '0' || ch == '1' || ch == '2' || ch == '3' ||
                        ch == '4' || ch == '7' || ch == '8' || ch == '9') {
                        grids[j][ (size + 3) * i + size + 1] = '|';
                    }
                    if (ch == '0' || ch == '2' || ch == '6' || ch == '8') {
                        grids[j + size + 1][ (size + 3) * i] = '|';
                    }
                    if (ch == '0' || ch == '1' || ch == '3' || ch == '4' ||
                        ch == '5' || ch == '6' || ch == '7' || ch == '8' ||
                        ch == '9') {
                        grids[j + size + 1][ (size + 3) * i + size + 1] = '|';
                    }
                }
            }
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    System.out.print(grids[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        while (true);
    }
}
