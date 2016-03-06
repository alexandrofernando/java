package P3030__Nasty_Hacks;

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
            int R = cin.nextInt();
            int E = cin.nextInt();
            int C = cin.nextInt();
            if (E > R + C) {
                System.out.println("advertise");
            } else if (E == R + C) {
                System.out.println("does not matter");
            } else {
                System.out.println("do not advertise");
            }
        }
    }
}
