package P2578__Keep_On_Truck_In;

import java.util.Scanner;

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
        int result = -1;
        for (int i = 0; i < 3; i++) {
            int height = cin.nextInt();
            if (result == -1 && height <= 168) {
                result = height;
            }
        }
        if (result == -1) {
            System.out.println("NO CRASH");
        }
        else {
            System.out.println("CRASH " + result);
        }
    }
}
