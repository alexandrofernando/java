package P1061__Frog_Appointment;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        long x = cin.nextLong();
        long y = cin.nextLong();
        long m = cin.nextLong();
        long n = cin.nextLong();
        long L = cin.nextLong();
        x %= L;
        y %= L;
        m %= L;
        n %= L;
        long distance = y - x;
        long chase = m - n;
        if (chase == 0) {
            System.out.println("Impossible");
        }
        else {
            if (chase < 0) {
                chase = -chase;
                distance = -distance;
            }
            if (distance < 0) {
                distance += L;
            }
            if (distance % chase == 0) {
                System.out.println(distance / chase);
            }
            else {
                long jump = distance / chase;
                long target = chase - distance % chase;
                long quo = L / chase;
                long mod = L % chase;
                long current = 0;
                do {
                    jump += quo;
                    current = current + mod;
                    if (current >= chase) {
                        current -= chase;
                        jump++;
                    }
                    if (current == target) {
                        System.out.println(jump + 1);
                        break;
                    }
                }
                while (current != 0);
                if (current == 0) {
                    System.out.println("Impossible");
                }
            }
        }
    }
}
