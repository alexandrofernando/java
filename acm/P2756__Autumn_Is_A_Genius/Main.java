package P2756__Autumn_Is_A_Genius;

import java.util.Scanner;
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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            String str = cin.next();
            if (str.charAt(0) == '+') {
                str = str.substring(1);
            }
            BigInteger a = new BigInteger(str);
            str = cin.next();
            if (str.charAt(0) == '+') {
                str = str.substring(1);
            }
            BigInteger b = new BigInteger(str);
            System.out.println(a.add(b));
        }
    }
}
