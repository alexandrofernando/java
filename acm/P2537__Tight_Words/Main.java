package P2537__Tight_Words;

import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

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
        while (cin.hasNextInt() == true) {
            int K = cin.nextInt();
            int n = cin.nextInt();
            BigDecimal counts[] = new BigDecimal[K + 1];
            for (int i = 0; i < counts.length; i++) {
                counts[i] = BigDecimal.ONE;
            }
            for (int i = 2; i <= n; i++) {
                BigDecimal temp[] = new BigDecimal[K + 1];
                for (int j = 0; j < counts.length; j++) {
                    temp[j] = BigDecimal.ZERO;
                    for (int k = -1; k <= 1; k++) {
                        if (j + k >= 0 && j + k <= K) {
                            temp[j] = temp[j].add(counts[j + k]);
                        }
                    }
                }
                counts = temp;
            }
            BigDecimal sum = BigDecimal.ZERO;
            for (int i = 0; i < counts.length; i++) {
                sum = sum.add(counts[i]);
            }
            BigDecimal total = BigDecimal.ONE;
            BigDecimal temp = new BigDecimal(K + 1);
            for (int i = 1; i <= n; i++) {
                total = total.multiply(temp);
            }
            double result = sum.doubleValue() / total.doubleValue() * 100;
            System.out.printf("%.5f\n", result);
        }
    }
}
