package P1580__String_Matching;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-18
 * Time: 21:04:22
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str1 = in.next();
            if (str1.equals("-1") == true) {
                break;
            }
            String str2 = in.next();
            int length1 = str1.length();
            int length2 = str2.length();
            int max = 0;
            for (int offset = -length1 + 1; offset <= length2 - 1; offset++) {
                int common = 0;
                for (int i = 0; i < length2; i++) {
                    int index = i + offset;
                    if (index >= 0 && index < length1 && str1.charAt(index) == str2.charAt(i)) {
                        common++;
                    }
                }
                if (common > max) {
                    max = common;
                }
            }
            System.out.print("appx(" + str1 + "," + str2 + ") = ");
            if (max == 0) {
                System.out.println(0);
            } else if (max == length1 && max == length2) {
                System.out.println(1);
            } else {
                int numerator = max * 2;
                int denominator = length1 + length2;
                int temp = GCD(numerator, denominator);
                numerator /= temp;
                denominator /= temp;
                System.out.println(numerator + "/" + denominator);
            }
        }
    }

    static int GCD(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
