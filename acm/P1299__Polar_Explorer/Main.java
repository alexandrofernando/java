package P1299__Polar_Explorer;

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
            String str = cin.next();
            if (str.equals("ENDOFINPUT") == true) {
                break;
            }
            int X = cin.nextInt();
            int Y = cin.nextInt();
            int Z = cin.nextInt();
            if (Z > 180) {
                Z = 360 - Z;
            }
            double distance = Z * 3.14159 / 180 * X * 2;
            if (Y * 5 >= distance) {
                int rest = (int) ((Y * 5 - distance) / 5);
                System.out.println("YES " + rest);
            } else {
                System.out.println("NO " + Y * 5);
            }
            cin.next();
        }
    }
}
