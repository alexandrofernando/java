package P1011__Sticks;

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
    static int copy[] = new int[51];
    static int number;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int temp = cin.nextInt();
        while (temp != 0) {
            int count[] = new int[51];
            int max = 0;
            int sum = 0;
            number = 0;
            for (int i = 0; i < temp; i++) {
                int length = cin.nextInt();
                if (length <= 50) {
                    number++;
                    count[length]++;
                    sum += length;
                    if (length > max) {
                        max = length;
                    }
                }
            }
            if (max == 0) {
                System.out.println(0);
            }
            else {
                for (int i = max; i <= sum; i++) {
                    if (sum % i == 0) {
                        System.arraycopy(count, 0, copy, 0, 51);
                        if (check(0, 0, i) == true) {
                            System.out.println(i);
                            break;
                        }
                    }
                }
            }
            temp = cin.nextInt();
        }
    }

    static boolean check(int depth, int current, int length) {
        if (depth == number) {
            return true;
        }
        boolean isFirst = false;
        if (current == 0) {
            current = length;
            isFirst = true;
        }
        for (int i = current > 50 ? 50 : current; i >= 1; i--) {
            if (copy[i] > 0) {
                copy[i]--;
                if (check(depth + 1, current - i, length) == true) {
                    return true;
                }
                copy[i]++;
                if (isFirst == true || current == i) {
                    break;
                }
            }
        }
        return false;
    }
}
