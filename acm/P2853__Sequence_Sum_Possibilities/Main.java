package P2853__Sequence_Sum_Possibilities;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            System.out.print(cin.nextInt());
            long number = cin.nextLong();
            number *= 2;
            int count = 0;
            for (long i = 2; i * i <= number; i++) {
                if (number % i == 0 && (i % 2 == 1 || number / i % 2 == 1)) {
                    count++;
                }
            }
            System.out.println(" " + count);
        }
    }
}
