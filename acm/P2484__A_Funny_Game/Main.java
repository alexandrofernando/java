package P2484__A_Funny_Game;

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
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            if (n <= 2) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
    }
}
