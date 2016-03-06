package P1702__Eva_s_Balance;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int W = cin.nextInt();
            ArrayList<Integer> left = new ArrayList<Integer>();
            ArrayList<Integer> right = new ArrayList<Integer>();
            int poise = 1;
            while (W != 0) {
                int temp = W % 3;
                if (temp == 1) {
                    right.add(poise);
                    W = (W - 1) / 3;
                } else if (temp == 2) {
                    left.add(poise);
                    W = (W + 1) / 3;
                } else {
                    W /= 3;
                }
                poise *= 3;
            }
            if (left.isEmpty() == true) {
                System.out.print("empty");
            } else {
                for (int i = 0; i < left.size(); i++) {
                    if (i != 0) {
                        System.out.print(",");
                    }
                    System.out.print(left.get(i));
                }
            }
            System.out.print(" ");
            if (right.isEmpty() == true) {
                System.out.print("empty");
            } else {
                for (int i = 0; i < right.size(); i++) {
                    if (i != 0) {
                        System.out.print(",");
                    }
                    System.out.print(right.get(i));
                }
            }
            System.out.println();
        }
    }
}
