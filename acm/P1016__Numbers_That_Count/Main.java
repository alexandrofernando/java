package P1016__Numbers_That_Count;

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
    static String numbers[] = new String[16];
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        numbers[0] = cin.next();
        while (numbers[0].equals("-1") == false) {
            boolean power = false;
            for (int i = 1; i <= 15; i++) {
                iterate(i);
                for (int j = 0; j < i; j++) {
                    if (numbers[i].equals(numbers[j]) == true) {
                        if (i == 1) {
                            System.out.println(numbers[0] +
                                               " is self-inventorying");
                        }
                        else if (i - j == 1) {
                            System.out.println(numbers[0] +
                                               " is self-inventorying after " +
                                               j + " steps");
                        }
                        else {
                            System.out.println(numbers[0] +
                                               " enters an inventory loop of length " +
                                               (i - j));
                        }
                        power = true;
                        break;
                    }
                }
                if (power == true) {
                    break;
                }
            }
            if (power == false) {
                System.out.println(numbers[0] +
                                   " can not be classified after 15 iterations");
            }
            numbers[0] = cin.next();
        }
    }

    public static void iterate(int step) {
        int count[] = new int[10];
        for (int i = 0; i < numbers[step - 1].length(); i++) {
            count[numbers[step - 1].charAt(i) - '0']++;
        }
        numbers[step] = new String("");
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) {
                numbers[step] += (count[i] + "" + i);
            }
        }
    }
}
