package P1012__Joseph;

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
    public static void main(String args[]) throws Exception {
        int result[] = new int[14];
        for (int i = 1; i < result.length; i++) {
            int cycle = 0;
            boolean power = false;
            while (!power) {
                boolean possible[] = new boolean[i + 1];
                for (int j = 1; j <= i; j++) {
                    possible[j] = true;
                }
                for (int j = 1; j <= i; j++) {
                    if (possible[j] == true && check(i, i + cycle + j, possible) == true) {
                        result[i] = i + cycle + j;
                        power = true;
                        break;
                    }
                }
                cycle += i * 2;
            }
        }
        Scanner cin = new Scanner(System.in);
        int k = cin.nextInt();
        while (k != 0) {
            System.out.println(result[k]);
            k = cin.nextInt();
        }
    }

    static boolean check(int number, int step, boolean possible[]) {
        int a[] = new int[number * 2];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        int current = -1;
        int length = a.length;
        for (int i = 0; i < number; i++) {
            current = (current + step) % length;
            if (a[current] < number) {
                for (int j = step + 1; j <= number; j++) {
                    int pos = (current + (j - step) * (i + 1)) % length;
                    if (a[pos] < number) {
                        possible[j] = false;
                    }
                }
                return false;
            }
            else {
                length--;
                current--;
            }
        }
        return true;
    }
}
