package P2070__Filling_Out_The_Team;

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
            double speed = cin.nextDouble();
            double weight = cin.nextDouble();
            double strength = cin.nextDouble();
            if (speed == 0 && weight == 0 && strength == 0) {
                break;
            }
            boolean power = false;
            if (speed <= 4.5 && weight >= 150 && strength >= 200) {
                System.out.print("Wide Receiver ");
                power = true;
            }
            if (speed <= 6.0 && weight >= 300 && strength >= 500) {
                System.out.print("Lineman ");
                power = true;
            }
            if (speed <= 5.0 && weight >= 200 && strength >= 300) {
                System.out.print("Quarterback ");
                power = true;
            }
            if (power == false) {
                System.out.print("No positions");
            }
            System.out.println();
        }
        while (true);
    }
}
