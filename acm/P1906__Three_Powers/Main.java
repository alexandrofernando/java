package P1906__Three_Powers;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.math.BigInteger;

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
        BigInteger set[] = new BigInteger[64];
        set[0] = new BigInteger("1");
        for (int i = 1; i < set.length; i++) {
            set[i] = set[i - 1].multiply(new BigInteger("3"));
        } while (true) {
            BigInteger n = cin.nextBigInteger();
            if (n.compareTo(BigInteger.ZERO) == 0) {
                break;
            }
            n = n.subtract(BigInteger.ONE);
            ArrayList<BigInteger> result = new ArrayList<BigInteger>();
            int index = 0;
            while (n.compareTo(BigInteger.ZERO) != 0) {
                BigInteger remainder = n.remainder(new BigInteger("2"));
                if (remainder.compareTo(BigInteger.ONE) == 0) {
                    result.add(set[index]);
                }
                n = n.divide(new BigInteger("2"));
                index++;
            }
            System.out.print("{");
            for (int i = 0; i < result.size(); i++) {
                if (i != 0) {
                    System.out.print(",");
                }
                System.out.printf(" " + result.get(i));
            }
            System.out.println(" }");
        }
    }
}
