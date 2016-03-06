package P2505__A_Multiplication_Game;

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
        while (cin.hasNextLong() == true) {
            long n = cin.nextLong();
            int person = win(1, n, 1);
            if (person == 1) {
                System.out.println("Stan wins.");
            } else {
                System.out.println("Ollie wins.");
            }
        }
    }

    static int win(long p, long n, int turn) {
        if (p * 9 >= n) {
            return turn;
        }
        for (int i = 9; i >= 2; i--) {
            if (win(p * i, n, -turn) == turn) {
                return turn;
            }
        }
        return -turn;
    }
}
