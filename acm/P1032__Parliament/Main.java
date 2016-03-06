package P1032__Parliament;

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
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int sum = 0;
        int length = 0;
        for (int i = 2; sum + i <= n; i++) {
            sum += i;
            length++;
        }
        int remain = n - sum;
        int offset = remain / length;
        int extra = remain % length;
        for (int i = 2; i < length + 2; i++) {
            if (i != 2) {
                System.out.print(" ");
            }
            if (i >= length - extra + 2) {
                System.out.print(i + offset + 1);
            }
            else {
                System.out.print(i + offset);
            }
        }
        System.out.println();
    }
}
