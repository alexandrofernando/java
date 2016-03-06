package P1207__The_3n_Add_1_Problem;

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
    static int cycles[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        cycles = new int[10000];
        for (int i = 1; i < 10000; i++) {
            if (cycles[i] == 0) {
                cycles[i] = search(i);
            }
        }
        while (cin.hasNextInt() == true) {
            int first = cin.nextInt();
            int second = cin.nextInt();
            int bottom = Math.min(first, second);
            int top = Math.max(first, second);
            int max = 0;
            for (int i = bottom; i <= top; i++) {
                if (cycles[i] > max) {
                    max = cycles[i];
                }
            }
            System.out.println(first + " " + second + " " + max);
        }
    }

    static int search(int number) {
        if (number < 10000 && cycles[number] != 0) {
            return cycles[number];
        }
        if (number == 1) {
            cycles[number] = 1;
            return 1;
        }
        int temp;
        if (number % 2 == 1) {
            temp = search(number * 3 + 1);
        }
        else {
            temp = search(number / 2);
        }
        if (number < 10000) {
            cycles[number] = temp + 1;
        }
        return temp + 1;
    }
}
