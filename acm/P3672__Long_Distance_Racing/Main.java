package P3672__Long_Distance_Racing;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-10
 * Time: 17:30:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int T = in.nextInt();
        int U = in.nextInt();
        int F = in.nextInt();
        int D = in.nextInt();
        int rest = M;
        int farthest = 0;
        for (int i = 0; i < T; i++) {
            String segment = in.next();
            if (segment.equals("f")) {
                if (rest >= F + F) {
                    rest -= F + F;
                    farthest++;
                } else {
                    rest = -1;
                }
            } else {
                if (rest >= U + D) {
                    rest -= U + D;
                    farthest++;
                } else {
                    rest = -1;
                }
            }
        }
        System.out.println(farthest);
    }
}
