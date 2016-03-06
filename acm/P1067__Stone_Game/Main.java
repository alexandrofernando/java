package P1067__Stone_Game;

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
        double alpha = (1 + Math.sqrt(5)) / 2;
        double beta = (3 + Math.sqrt(5)) / 2;
        while (cin.hasNext() == true) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int result;
            if (a == 0) {
                result = 1;
            }
            else {
                int n = (int) Math.ceil(a / alpha);
                if ( (int) Math.floor(n * beta) == b) {
                    result = 0;
                }
                else {
                    result = 1;
                }
            }
            System.out.println(result);
        }
    }
}
