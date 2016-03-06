package P1078__Gizilch;

import java.util.Scanner;

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
    static boolean minTruth;
    static boolean possible;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt() == true) {
            int max = cin.nextInt();
            int min = cin.nextInt();
            if (min > max) {
                int temp = min;
                min = max;
                max = temp;
            }
            minTruth = false;
            possible = false;
            referee(max, min, 100);
            if (possible == true || minTruth == false) {
                System.out.println(max);
            }
            else {
                System.out.println(min);
            }
        }
    }

    public static void referee(int max, int min, int number) {
        if (number == 1) {
            if (min == 1) {
                minTruth = true;
            }
            if (max == 1 && min == 1) {
                possible = true;
            }
        }
        else if (possible == false) {
            if (max % number != 0 && min % number != 0) {
                referee(max, min, number - 1);
            }
            else if (max % number == 0 && min % number != 0) {
                referee(max, min, number - 1);
                referee(max / number, min, number - 1);
            }
            else if (max % number != 0 && min % number == 0) {
                referee(max, min, number - 1);
                referee(max, min / number, number - 1);
            }
            else if (max % number == 0 && min % number == 0) {
                referee(max, min, number - 1);
                referee(max / number, min, number - 1);
                referee(max, min / number, number - 1);
            }
        }
    }
}
