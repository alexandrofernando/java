package P2666__Back_To_Mother_Ship;

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
        while (true) {
            int speed = cin.nextInt();
            int angle = cin.nextInt();
            int distance = cin.nextInt();
            if (speed == 0 && angle == 0 && distance == 0) {
                break;
            }
            int time = (int) Math.round((Math.exp(angle * Math.PI / 180 /
                                                  Math.sqrt(3)) * distance -
                                         distance) / speed);
            if (time > 10000) {
                System.out.println("God help me!");
            } else {
                System.out.println(time);
            }
        }
    }
}
