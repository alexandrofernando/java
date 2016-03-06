package P1047__Round_And_Round_We_Go;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext() == true) {
            String temp = cin.next();
            int length = temp.length();
            int integer[] = new int[length];
            for (int i = 0; i < length; i++) {
                integer[i] = temp.charAt(length - 1 - i) - '0';
            }
            boolean cyclic = true;
            for (int i = 1; i <= length; i++) {
                int product[] = multiply(integer, i, length);
                if (isCycle(integer, product, length) == false) {
                    cyclic = false;
                    break;
                }
            }
            if (cyclic == true) {
                System.out.println(temp + " is cyclic");
            }
            else {
                System.out.println(temp + " is not cyclic");
            }
        }
    }

    public static int[] multiply(int integer[], int n, int length) {
        int result[] = new int[length];
        int carry = 0;
        for (int i = 0; i < length; i++) {
            result[i] = (integer[i] * n + carry) % 10;
            carry = (integer[i] * n + carry) / 10;
        }
        return result;
    }

    public static boolean isCycle(int a[], int b[], int length) {
        for (int offset = 0; offset < length; offset++) {
            boolean cycle = true;
            for (int i = 0; i < length; i++) {
                if (a[i] != b[ (i + offset) % length]) {
                    cycle = false;
                    break;
                }
            }
            if (cycle == true) {
                return true;
            }
        }
        return false;
    }
}
