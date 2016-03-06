package P3039__Close_Encounter;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-11
 * Time: 20:14:17
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();
        double value = (double) N / D;
        int numerator = -1;
        int denominator = -1;
        double error = Double.MAX_VALUE;
        for (int i = 1; i <= 32767; i++) {
            int bottom = (int) Math.floor(i * value);
            if (bottom >= 1 && N * i != D * bottom && Math.abs((double) bottom / i - value) < error) {
                numerator = bottom;
                denominator = i;
                error = Math.abs((double) bottom / i - value);
            }
            int top = (int) Math.ceil(i * value);
            if (top <= 32767 && N * i != D * top && Math.abs((double) top / i - value) < error) {
                numerator = top;
                denominator = i;
                error = Math.abs((double) top / i - value);
            }
        }
        System.out.println(numerator + " " + denominator);
    }
}
