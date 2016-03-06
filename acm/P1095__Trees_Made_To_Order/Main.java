package P1095__Trees_Made_To_Order;

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
    static int number[] = new int[19];
    public static void main(String args[]) throws Exception {
        number[0] = 1;
        for (int i = 1; i < number.length; i++) {
            number[i] = 0;
            for (int j = 0; j < i; j++) {
                number[i] += number[j] * number[i - 1 - j];
            }
        }
        Scanner cin = new Scanner(System.in);
        int n;
        while ( (n = cin.nextInt()) != 0) {
            int sum = 0;
            int i;
            for (i = 0; n + 1 > sum; i++) {
                sum += number[i];
            }
            display(i - 1, n - sum + number[i - 1]);
            System.out.println();
        }
    }

    public static void display(int node, int serial) {
        int leftNode = 0, rightNode = node - 1;
        while (serial >= number[leftNode] * number[rightNode]) {
            serial -= number[leftNode] * number[rightNode];
            leftNode++;
            rightNode--;
        }
        if (leftNode > 0) {
            System.out.print("(");
            display(leftNode, serial / number[rightNode]);
            System.out.print(")");
        }
        System.out.print("X");
        if (rightNode > 0) {
            System.out.print("(");
            display(rightNode, serial % number[rightNode]);
            System.out.print(")");
        }
    }
}
