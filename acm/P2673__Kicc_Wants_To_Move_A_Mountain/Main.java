package P2673__Kicc_Wants_To_Move_A_Mountain;

import java.util.Scanner;
import java.io.File;

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
        int t = cin.nextInt();
        int x = cin.nextInt();
        int m = cin.nextInt();
        int time = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int d = cin.nextInt();
            int s = cin.nextInt();
            int temp = d / s;
            if (temp * s == d) {
                temp--;
            }
            if (temp < time) {
                time = temp;
            }
        }
        int stoneTime;
        if (time == 0) {
            stoneTime = 0;
        } else if (t <= time) {
            stoneTime = t;
        } else {
            stoneTime = time + (t - time) / 2;
        }
        int stone = stoneTime * x;
        System.out.println(stone);
    }
}
