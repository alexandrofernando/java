package P2402__Palindrome_Numbers;

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
            int index = cin.nextInt();
            if (index == 0) {
                break;
            }
            int digit = (int) Math.floor(Math.log10((index - 1) / 2.0 + 1));
            int temp = (int) Math.pow(10, digit);
            int rest = index - 2 * (temp - 1);
            if (rest <= 9 * temp) {
                String str = Integer.toString(temp + rest - 1);
                for (int i = str.length() - 2; i >= 0; i--) {
                    str += str.charAt(i);
                }
                System.out.println(str);
            } else {
                String str = Integer.toString(rest - 1 - 8 * temp);
                for (int i = str.length() - 1; i >= 0; i--) {
                    str += str.charAt(i);
                }
                System.out.println(str);
            }
        }
    }
}
