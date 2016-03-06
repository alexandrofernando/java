package P1063__Flip_And_Shift;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int number = cin.nextInt();
            int sum = 0;
            int addition[] = {
                -1, 1};
            for (int i = 0; i < number; i++) {
                if (cin.nextInt() == 1) {
                    sum += addition[i % 2];
                }
            }
            if ( (number % 2 == 0 && sum >= -1 && sum <= 1) || number % 2 == 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
