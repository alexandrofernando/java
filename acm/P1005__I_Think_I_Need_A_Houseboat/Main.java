package P1005__I_Think_I_Need_A_Houseboat;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 1; i <= N; i++) {
            double X = cin.nextDouble();
            double Y = cin.nextDouble();
            int year = (int) Math.ceil(Math.PI * (X * X + Y * Y) / 100);
            System.out.println("Property " + i +
                               ": This property will begin eroding in year " +
                               year + ".");
        }
        System.out.println("END OF OUTPUT.");
    }
}
