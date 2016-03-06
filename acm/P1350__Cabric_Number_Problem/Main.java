package P1350__Cabric_Number_Problem;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
            if (str.equals("-1") == true) {
                break;
            }
            System.out.println("N=" + str + ":");
            boolean power = true;
            if (str.length() != 4 ||
                (str.charAt(0) == str.charAt(1) &&
                 str.charAt(1) == str.charAt(2) &&
                 str.charAt(2) == str.charAt(3))) {
                System.out.println("No!!");
            } else {
                int digits[] = new int[4];
                for (int i = 0; i < 4; i++) {
                    digits[i] = str.charAt(i) - '0';
                }
                int times = 1;
                while (true) {
                    Arrays.sort(digits);
                    int min = getMin(digits);
                    int max = getMax(digits);
                    int difference = max - min;
                    System.out.println(max + "-" + min + "=" + difference);
                    if (difference == 6174 || difference == 0) {
                        System.out.println("Ok!! " + times + " times");
                        break;
                    } else if (difference == 999) {
                        System.out.println("999-999=0");
                        System.out.println("Ok!! " + (times + 1) + " times");
                        break;
                    }
                    divide(digits, difference);
                    times++;
                }
            }
        }
    }

    static int getMin(int digits[]) {
        return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
    }

    static int getMax(int digits[]) {
        return digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
    }

    static void divide(int digits[], int number) {
        for (int i = 0; i < 4; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
    }
}
