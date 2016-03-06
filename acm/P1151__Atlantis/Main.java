package P1151__Atlantis;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
        int test = 1;
        do {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            ArrayList<Double> x = new ArrayList<Double> ();
            ArrayList<Double> y = new ArrayList<Double> ();
            Rectangle rectangles[] = new Rectangle[n];
            for (int i = 0; i < n; i++) {
                rectangles[i] = new Rectangle(cin.nextDouble(), cin.nextDouble(),
                                              cin.nextDouble(), cin.nextDouble());
                if (x.contains(rectangles[i].x1) == false) {
                    x.add(rectangles[i].x1);
                }
                if (y.contains(rectangles[i].y1) == false) {
                    y.add(rectangles[i].y1);
                }
                if (x.contains(rectangles[i].x2) == false) {
                    x.add(rectangles[i].x2);
                }
                if (y.contains(rectangles[i].y2) == false) {
                    y.add(rectangles[i].y2);
                }
            }
            Collections.sort(x);
            Collections.sort(y);
            int numberX = x.size();
            int numberY = y.size();
            boolean filled[][] = new boolean[numberX][numberY];
            for (int i = 0; i < n; i++) {
                int left = x.indexOf(rectangles[i].x1);
                int top = y.indexOf(rectangles[i].y1);
                int right = x.indexOf(rectangles[i].x2);
                int bottom = y.indexOf(rectangles[i].y2);
                for (int j = left; j < right; j++) {
                    for (int k = top; k < bottom; k++) {
                        filled[j][k] = true;
                    }
                }
            }
            double area = 0;
            for (int i = 0; i < numberX; i++) {
                for (int j = 0; j < numberY; j++) {
                    if (filled[i][j] == true) {
                        area += (x.get(i + 1) - x.get(i)) *
                            (y.get(j + 1) - y.get(j));
                    }
                }
            }
            System.out.println("Test case #" + test);
            test++;
            System.out.printf("Total explored area: %.2f\n\n", area);
        }
        while (true);
    }
}

class Rectangle {
    double x1;
    double y1;
    double x2;
    double y2;
    public Rectangle(double X1, double Y1, double X2, double Y2) {
        this.x1 = X1;
        this.y1 = Y1;
        this.x2 = X2;
        this.y2 = Y2;
    }
}
