package P2562__Primary_Arithmetic;

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
            int a = cin.nextInt();
            int b = cin.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            int digits1[] = divide(a);
            int digits2[] = divide(b);
            int result = 0;
            int carry = 0;
            for (int i = 0; i < 11; i++) {
                carry = (digits1[i] + digits2[i] + carry) / 10;
                if (carry > 0) {
                    result++;
                }
            }
            if (result == 0) {
                System.out.println("No carry operation.");
            } else if (result == 1) {
                System.out.println("1 carry operation.");
            } else {
                System.out.println(result + " carry operations.");
            }
        }
    }

    static int[] divide(int number) {
        int digits[] = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
}
