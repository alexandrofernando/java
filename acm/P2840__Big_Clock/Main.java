package P2840__Big_Clock;

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
        cin.useDelimiter("\\p{javaWhitespace}+|:");
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int H = cin.nextInt();
            int M = cin.nextInt();
            if (M != 0) {
                System.out.println(0);
            } else {
                if (H == 0) {
                    System.out.println(12);
                } else if (H <= 12) {
                    System.out.println(H + 12);
                } else {
                    System.out.println(H - 12);
                }
            }
        }
    }
}
