package P1023__The_Fun_Number_System;

import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int bitNumber = cin.nextInt();
            String system = cin.next();
            BigDecimal N = cin.nextBigDecimal();
            int bits[] = new int[bitNumber];
            for (int i = bitNumber - 1; i >= 0; i--) {
                BigDecimal remainder = N.remainder(new BigDecimal(2));
                if (remainder.compareTo(new BigDecimal(0)) == 0) {
                    bits[i] = 0;
                    N = N.divide(new BigDecimal(2));
                }
                else {
                    bits[i] = 1;
                    if (system.charAt(i) == 'p') {
                        if (N.compareTo(new BigDecimal(0)) > 0) {
                            N = N.subtract(remainder).divide(new BigDecimal(2));
                        }
                        else {
                            N = N.add(remainder).divide(new BigDecimal(2));
                        }
                    }
                    else if (system.charAt(i) == 'n') {
                        if (N.compareTo(new BigDecimal(0)) > 0) {
                            N = N.add(remainder).divide(new BigDecimal(2));
                        }
                        else {
                            N = N.subtract(remainder).divide(new BigDecimal(2));
                        }
                    }
                }
            }
            if (N.compareTo(new BigDecimal(0)) == 0) {
                for (int i = 0; i < bitNumber; i++) {
                    System.out.print(bits[i]);
                }
                System.out.println();
            }
            else {
                System.out.println("Impossible");
            }
        }
    }
}
