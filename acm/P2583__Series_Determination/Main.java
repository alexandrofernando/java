package P2583__Series_Determination;

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
        while (cin.hasNextInt() == true) {
            int f0 = cin.nextInt();
            int f1 = cin.nextInt();
            int f2 = cin.nextInt();
            int C = f0;
            int A = (f2 - 2 * f1 + C) / 2;
            int B = f1 - A - C;
            int f3 = A * 9 + B * 3 + C;
            int f4 = A * 16 + B * 4 + C;
            int f5 = A * 25 + B * 5 + C;
            System.out.println(f3 + " " + f4 + " " + f5);
        }
    }
}
