package P2551__Ones;

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
        while (cin.hasNextInt() == true) {
            int n = cin.nextInt();
            int digits = 0;
            int mod = 0;
            do {
                mod = (mod * 10 + 1) % n;
                digits++;
            }
            while (mod != 0);
            System.out.println(digits);
        }
    }
}
