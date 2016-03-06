package P1003__Hangover;

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
        double c = cin.nextDouble();
        while (Math.abs(c) > 1E-6) {
            double sum = 0;
            int cards = 0;
            while (sum < c) {
                sum += 1.0 / (cards + 2);
                cards++;
            }
            System.out.println(cards + " card(s)");
            c = cin.nextDouble();
        }
    }
}
