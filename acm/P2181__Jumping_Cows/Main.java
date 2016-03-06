package P2181__Jumping_Cows;

import java.util.Scanner;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int jump = 0;
        int P = cin.nextInt();
        boolean up = true;
        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < P; i++) {
            int current = cin.nextInt();
            if (up == true) {
                if (current < previous) {
                    jump += previous;
                    up = false;
                }
            }
            else {
                if (current > previous) {
                    jump -= previous;
                    up = true;
                }
            }
            previous = current;
        }
        if (up == true) {
            jump += previous;
        }
        System.out.println(jump);
    }
}
