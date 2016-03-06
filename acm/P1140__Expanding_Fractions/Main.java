package P1140__Expanding_Fractions;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int numerator = cin.nextInt();
            int denominator = cin.nextInt();
            if (numerator == 0 && denominator == 0) {
                break;
            }
            int pos[] = new int[2000];
            for (int i = 0; i < pos.length; i++) {
                pos[i] = -1;
            }
            System.out.print(".");
            int count = 1;
            pos[numerator] = 0;
            numerator *= 10;
            while (true) {
                if (count % 50 == 0) {
                    System.out.println();
                }
                System.out.print(numerator / denominator);
                if (numerator % denominator == 0) {
                    System.out.println();
                    System.out.println("This expansion terminates.");
                    break;
                }
                int mod = numerator % denominator;
                if (pos[mod] == -1) {
                    pos[mod] = count;
                }
                else {
                    System.out.println();
                    System.out.println("The last " + (count - pos[mod]) +
                                       " digits repeat forever.");
                    break;
                }
                numerator = mod * 10;
                count++;
            }
        }
        while (true);
    }
}
