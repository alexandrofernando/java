package P1663__Number_Steps;

import java.util.Scanner;
import java.io.File;

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
            int x = cin.nextInt();
            int y = cin.nextInt();
            if (x == y || x == y + 2) {
                if (x % 2 == 0) {
                    System.out.println(x + y);
                }
                else {
                    System.out.println(x + y - 1);
                }
            }
            else {
                System.out.println("No Number");
            }
        }
    }
}
