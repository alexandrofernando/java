package P2590__Steps;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            int distance = y - x;
            if (distance == 0) {
                System.out.println(0);
            } else {
                int temp = (int) Math.floor(Math.sqrt(distance));
                if (temp * temp == distance) {
                    System.out.println(temp * 2 - 1);
                } else if (distance - temp * temp <= temp) {
                    System.out.println(temp * 2);
                } else {
                    System.out.println(temp * 2 + 1);
                }
            }
        }
    }
}
