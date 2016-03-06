package P1607__Deck;

import java.util.Scanner;
import java.io.File;

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
        double overhangs[] = new double[100000];
        double sum = 0;
        for (int i = 1; i < overhangs.length; i++) {
            sum += 0.5 / i;
            overhangs[i] = sum;
        }
        System.out.println("Cards  Overhang");
        while (cin.hasNextInt() == true) {
            int card = cin.nextInt();
            System.out.printf("%5d     %.3f\n", card, overhangs[card]);
        }
    }
}
