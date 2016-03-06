package P1079__Ratio;

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
        boolean power = false;
        while (cin.hasNextDouble() == true) {
            if (power == false) {
                power = true;
            }
            else {
                System.out.println();
            }
            double ratio = cin.nextDouble() / cin.nextDouble();
            int denominator = 1;
            System.out.println( (int) (ratio + 0.5) + "/1");
            double error = Math.abs( (int) (ratio + 0.5) - ratio);
            while (error >= 1E-12) {
                denominator++;
                int numerator = (int) (ratio * denominator + 0.5);
                double temp = Math.abs( (double) numerator / denominator -
                                       ratio);
                if (temp < error) {
                    System.out.println(numerator + "/" + denominator);
                    error = temp;
                }
            }
        }
    }
}
