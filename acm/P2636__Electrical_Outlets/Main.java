package P2636__Electrical_Outlets;

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
            int number = cin.nextInt();
            int result = 1;
            for (int i = 0; i < number; i++) {
                result += cin.nextInt() - 1;
            }
            System.out.println(result);
        }
    }
}
