package P1922__Ride_To_School;

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
        do {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            int arrival = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int speed = cin.nextInt();
                int setOff = cin.nextInt();
                if (setOff >= 0) {
                    int temp = (int) Math.ceil(16200.0 / speed + setOff);
                    if (temp < arrival) {
                        arrival = temp;
                    }
                }
            }
            System.out.println(arrival);
        }
        while (true);
    }
}
