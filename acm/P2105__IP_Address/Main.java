package P2105__IP_Address;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            String stream = cin.next();
            for (int i = 0; i < 4; i++) {
                int number = convert(stream.substring(i * 8, i * 8 + 8));
                if (i != 0) {
                    System.out.print(".");
                }
                System.out.print(number);
            }
            System.out.println();
        }
    }

    static int convert(String str) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result = result * 2 + (str.charAt(i) - '0');
        }
        return result;
    }
}
