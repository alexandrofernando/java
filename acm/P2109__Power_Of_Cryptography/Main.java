package P2109__Power_Of_Cryptography;

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
            int n = cin.nextInt();
            double p = cin.nextDouble();
            double K = Math.pow(p, 1.0 / n);
            System.out.printf("%.0f\n", K);
        }
    }
}
