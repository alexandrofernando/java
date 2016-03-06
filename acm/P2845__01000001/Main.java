package P2845__01000001;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            String a = cin.next();
            String b = cin.next();
            int length1 = a.length();
            int length2 = b.length();
            int length = Math.max(length1, length2) + 1;
            int carry = 0;
            String sum = "";
            for (int i = 0; i < length; i++) {
                int bit1 = 0;
                int bit2 = 0;
                if (i < length1) {
                    bit1 = a.charAt(length1 - i - 1) - '0';
                }
                if (i < length2) {
                    bit2 = b.charAt(length2 - i - 1) - '0';
                }
                char ch = (char) ((bit1 + bit2 + carry) % 2 + '0');
                sum = ch + sum;
                carry = (bit1 + bit2 + carry) / 2;
            } while (sum.length() > 1 && sum.charAt(0) == '0') {
                sum = sum.substring(1);
            }
            System.out.println(t + " " + sum);
        }
    }
}
