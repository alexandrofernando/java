package P1781__In_Danger;

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
            if (str.equals("00e0") == true) {
                break;
            }
            int temp1 = Integer.parseInt(str.substring(0, 2));
            int temp2 = Integer.parseInt(str.substring(3));
            int n = temp1;
            for (int i = 0; i < temp2; i++) {
                n *= 10;
            }
            int result = search(n);
            System.out.println(result);
        }
    }

    static int search(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else if (n % 2 == 0) {
            return search(n / 2) * 2 - 1;
        } else {
            int temp = search(n / 2 + 1);
            if (temp == 1) {
                return n;
            } else {
                return temp * 2 - 3;
            }
        }
    }
}
