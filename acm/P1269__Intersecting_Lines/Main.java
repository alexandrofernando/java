package P1269__Intersecting_Lines;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 18:13:51
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        System.out.println("INTERSECTING LINES OUTPUT");
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int x3 = in.nextInt();
            int y3 = in.nextInt();
            int x4 = in.nextInt();
            int y4 = in.nextInt();
            if ((y2 - y1) * (x4 - x3) == (x2 - x1) * (y4 - y3)) {
                if ((y3 - y1) * (x2 - x1) == (x3 - x1) * (y2 - y1)) {
                    System.out.println("LINE");
                } else {
                    System.out.println("NONE");
                }
            } else {
                double x = (((double) y3 * x4 - x3 * y4) * (x2 - x1) - ((double) y1 * x2 - x1 * y2) * (x4 - x3)) / ((y2 - y1) * (x4 - x3) - (y4 - y3) * (x2 - x1));
                double y = (((double) x3 * y4 - y3 * x4) * (y2 - y1) - ((double) x1 * y2 - y1 * x2) * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
                System.out.printf("POINT %.2f %.2f\n", x, y);
            }
        }
        System.out.println("END OF OUTPUT");
    }
}
