package P2027__No_Brainer;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int eat = cin.nextInt();
            int require = cin.nextInt();
            if (eat >= require) {
                System.out.println("MMM BRAINS");
            }
            else {
                System.out.println("NO BRAINS");
            }
        }
    }
}
