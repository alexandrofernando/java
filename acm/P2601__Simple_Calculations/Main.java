package P2601__Simple_Calculations;

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
        int n = cin.nextInt();
        double a0 = cin.nextDouble();
        double an_1 = cin.nextDouble();
        double temp = 0;
        for (int i = n * 2; i >= 2; i -= 2) {
            temp += i * cin.nextDouble();
        }
        double a1 = (an_1 + n * a0 - temp) / (n + 1);
        System.out.printf("%.2f\n", a1);
    }
}
