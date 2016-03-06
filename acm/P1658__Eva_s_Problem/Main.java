package P1658__Eva_s_Problem;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int numbers[] = new int[5];
            for (int i = 0; i < 4; i++) {
                numbers[i] = cin.nextInt();
            }
            int d = numbers[1] - numbers[0];
            int q = numbers[1] / numbers[0];
            boolean power = true;
            for (int i = 1; i < 4; i++) {
                if (numbers[i] - numbers[i - 1] != d) {
                    power = false;
                    break;
                }
            }
            if (power == true) {
                numbers[4] = numbers[3] + d;
            }
            else {
                numbers[4] = numbers[3] * q;
            }
            for (int i = 0; i < 5; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(numbers[i]);
            }
            System.out.println();
        }
    }
}
