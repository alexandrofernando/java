package P2575__Jolly_Jumpers;

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
        while (cin.hasNextInt() == true) {
            int n = cin.nextInt();
            boolean differs[] = new boolean[n];
            int previous = 0;
            boolean jolly = true;
            for (int i = 0; i < n; i++) {
                int number = cin.nextInt();
                if (i != 0) {
                    int temp = Math.abs(number - previous);
                    if (temp >= 1 && temp <= n - 1 && differs[temp] == false) {
                        differs[temp] = true;
                    } else {
                        jolly = false;
                    }
                }
                previous = number;
            }
            if (jolly == true) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
    }
}
