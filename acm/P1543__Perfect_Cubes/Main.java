package P1543__Perfect_Cubes;

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
        int N = cin.nextInt();
        for (int a = 3; a <= N; a++) {
            for (int b = 2; a * a * a >= b * b * b * 3; b++) {
                for (int c = b; a * a * a - b * b * b >= c * c * c * 2; c++) {
                    for (int d = c;
                                 a * a * a - b * b * b - c * c * c >= d * d * d;
                                 d++) {
                        if (a * a * a == b * b * b + c * c * c + d * d * d) {
                            System.out.println("Cube = " + a + ", Triple = (" +
                                               b + "," + c + "," + d + ")");
                        }
                    }
                }
            }
        }
    }
}
