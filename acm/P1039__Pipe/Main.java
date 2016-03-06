package P1039__Pipe;

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
    static int n;
    static double x[], y[];
    static double farthest;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        while (n != 0) {
            x = new double[n];
            y = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = cin.nextDouble();
                y[i] = cin.nextDouble();
            }
            double max = x[0];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (check(i, j, true, true) == true) {
                        if (farthest > max) {
                            max = farthest;
                        }
                    }
                    if (check(i, j, true, false) == true) {
                        if (farthest > max) {
                            max = farthest;
                        }
                    }
                    if (check(i, j, false, true) == true) {
                        if (farthest > max) {
                            max = farthest;
                        }
                    }
                    if (check(i, j, false, false) == true) {
                        if (farthest > max) {
                            max = farthest;
                        }
                    }
                }
            }
            if (max < x[n - 1] - (1E-9)) {
                System.out.printf("%.2f\n", max);
            }
            else {
                System.out.println("Through all the pipe.");
            }
            n = cin.nextInt();
        }
    }

    public static boolean check(int start, int end, boolean startTop,
                                boolean endTop) {
        double x1, y1, x2, y2;
        x1 = x[start];
        if (startTop == true) {
            y1 = y[start];
        }
        else {
            y1 = y[start] - 1;
        }
        x2 = x[end];
        if (endTop == true) {
            y2 = y[end];
        }
        else {
            y2 = y[end] - 1;
        }
        double k = (y2 - y1) / (x2 - x1);
        double b = y2 - k * x2;
        for (int i = 0; i < end; i++) {
            double temp = k * x[i] + b;
            if (temp > y[i] + (1E-9) || temp < y[i] - 1 - (1E-9)) {
                return false;
            }
        }
        for (int i = end + 1; i < n; i++) {
            double temp = k * x[i] + b;
            if (temp > y[i] + (1E-9) || temp < y[i] - 1 - (1E-9)) {
                double tempK = (y[i] - y[i - 1]) / (x[i] - x[i - 1]);
                double tempB = y[i] - tempK * x[i];
                double tempX1 = (tempB - b) / (k - tempK);
                tempB--;
                double tempX2 = (tempB - b) / (k - tempK);
                if (tempX1 > tempX2) {
                    farthest = tempX1;
                }
                else {
                    farthest = tempX2;
                }
                return true;
            }
        }
        farthest = x[n - 1];
        return true;
    }
}
