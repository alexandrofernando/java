package P2348__Euclid_s_Game;

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
            int a = cin.nextInt();
            int b = cin.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            boolean stanWin = true;
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            } while (true) {
                if (a % b == 0 || a / b > 1) {
                    break;
                }
                int temp = a % b;
                a = b;
                b = temp;
                stanWin = !stanWin;
            }
            if (stanWin == true) {
                System.out.println("Stan wins");
            } else {
                System.out.println("Ollie wins");
            }
        }
    }
}
