package P2017__Speed_Limit;

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
            int n = cin.nextInt();
            if (n == -1) {
                break;
            }
            int distance = 0;
            int previous = 0;
            for (int i = 0; i < n; i++) {
                int speed = cin.nextInt();
                int time = cin.nextInt();
                distance += speed * (time - previous);
                previous = time;
            }
            System.out.println(distance + " miles");
        }
        while (true);
    }
}
