package P1183__Arctan;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        long a = cin.nextLong();
        for (long i = (long) Math.sqrt(a * a + 1); i > 0; i--) {
            if ( (a * a + 1) % i == 0) {
                long b = i + a;
                long c = (a * a + 1) / i + a;
                System.out.println(b + c);
                break;
            }
        }
    }
}
