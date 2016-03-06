package P1326__Mileage_Bank;

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
            String str = cin.next();
            if (str.equals("#") == true) {
                break;
            }
            int earn = 0;
            do {
                cin.next();
                int miles = cin.nextInt();
                String classCode = cin.next();
                if (classCode.equals("F") == true) {
                    earn += miles * 2;
                }
                else if (classCode.equals("B") == true) {
                    earn += miles * 1.5 + 0.5;
                }
                else if (miles <= 500) {
                    earn += 500;
                }
                else {
                    earn += miles;
                }
                str = cin.next();
            }
            while (str.equals("0") == false);
            System.out.println(earn);
        }
        while (true);
    }
}
