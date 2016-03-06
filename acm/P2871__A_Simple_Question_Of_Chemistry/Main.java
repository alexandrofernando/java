package P2871__A_Simple_Question_Of_Chemistry;

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
        double previous = cin.nextDouble();
        while (true) {
            double current = cin.nextDouble();
            if (Math.abs(current - 999) < 1E-6) {
                break;
            }
            System.out.printf("%.2f\n", current - previous);
            previous = current;
        }
        System.out.println("End of Output");
    }
}
