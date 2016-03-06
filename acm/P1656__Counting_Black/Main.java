package P1656__Counting_Black;

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
        boolean grids[][] = new boolean[101][101];
        int number = cin.nextInt();
        for (int i = 0; i < number; i++) {
            String command = cin.next();
            int x = cin.nextInt();
            int y = cin.nextInt();
            int L = cin.nextInt();
            if (command.equals("WHITE") == true) {
                for (int j = x; j < x + L; j++) {
                    for (int k = y; k < y + L; k++) {
                        grids[j][k] = false;
                    }
                }
            }
            else if (command.equals("BLACK") == true) {
                for (int j = x; j < x + L; j++) {
                    for (int k = y; k < y + L; k++) {
                        grids[j][k] = true;
                    }
                }
            }
            else if (command.endsWith("TEST") == true) {
                int count = 0;
                for (int j = x; j < x + L; j++) {
                    for (int k = y; k < y + L; k++) {
                        if (grids[j][k] == true) {
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
}
