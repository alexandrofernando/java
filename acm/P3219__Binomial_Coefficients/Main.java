package P3219__Binomial_Coefficients;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-31
 * Time: 9:06:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int N = in.nextInt();
            int K = in.nextInt();
            if ((N & K) == K) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
