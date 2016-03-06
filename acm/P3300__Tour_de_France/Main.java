package P3300__Tour_de_France;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-17
 * Time: 1:25:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int f = in.nextInt();
            if (f == 0) {
                break;
            }
            int r = in.nextInt();
            int fronts[] = new int[f];
            int rears[] = new int[r];
            for (int i = 0; i < f; i++) {
                fronts[i] = in.nextInt();
            }
            for (int i = 0; i < r; i++) {
                rears[i] = in.nextInt();
            }
            double ratios[] = new double[f * r];
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < r; j++) {
                    ratios[i * r + j] = (double) fronts[i] / rears[j];
                }
            }
            Arrays.sort(ratios);
            double max = 0;
            for (int i = 0; i < ratios.length - 1; i++) {
                double temp = ratios[i + 1] / ratios[i];
                if (temp > max) {
                    max = temp;
                }
            }
            System.out.printf("%.2f\n", max);
        }
    }
}
