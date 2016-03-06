package P2719__Faulty_Odometer;

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
            String odometer = cin.next();
            if (odometer.equals("0") == true) {
                break;
            }
            System.out.print(odometer + ": ");
            int result = 0;
            for (int i = 0; i < odometer.length(); i++) {
                char ch = odometer.charAt(i);
                if (ch < '4') {
                    result = result * 9 + ch - '0';
                } else {
                    result = result * 9 + ch - '0' - 1;
                }
            }
            System.out.println(result);
        }
    }
}
