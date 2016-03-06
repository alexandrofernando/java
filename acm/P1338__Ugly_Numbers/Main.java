package P1338__Ugly_Numbers;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Long> numbers = new ArrayList<Long>();
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 30; k++) {
                    numbers.add((long) (Math.pow(5, i) * Math.pow(3, j) *
                                        Math.pow(2, k)));
                }
            }
        }
        Collections.sort(numbers);
        while (true) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(numbers.get(n - 1));
        }
    }
}
