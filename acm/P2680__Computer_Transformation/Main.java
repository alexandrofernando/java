package P2680__Computer_Transformation;

import java.util.Scanner;
import java.io.File;
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
        BigInteger pairs[] = new BigInteger[1000];
        pairs[1] = BigInteger.ZERO;
        for (int i = 2; i < pairs.length; i++) {
            if (i % 2 == 0) {
                pairs[i] = pairs[i -
                           1].multiply(new BigInteger("2")).add(BigInteger.ONE);
            } else {
                pairs[i] = pairs[i -
                           1].multiply(new BigInteger("2")).subtract(BigInteger.
                        ONE);
            }
        } while (cin.hasNextInt() == true) {
            System.out.println(pairs[cin.nextInt()]);
        }
    }
}
