package P3122__Pie;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 21:44:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = in.nextInt();
            int F = in.nextInt();
            double area[] = new double[N];
            double total = 0;
            for (int i = 0; i < N; i++) {
                int radius = in.nextInt();
                area[i] = Math.PI * radius * radius;
                total += area[i];
            }
            double bottom = 0;
            double top = total / (F + 1);
            while (top - bottom > 1E-3) {
                double middle = (top + bottom) / 2;
                int count = 0;
                for (int i = 0; i < N; i++) {
                    count += (int) Math.floor(area[i] / middle);
                }
                if (count >= F + 1) {
                    bottom = middle;
                } else {
                    top = middle;
                }
            }
            System.out.println((top + bottom) / 2);
        }
    }
}
