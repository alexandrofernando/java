package P2234__Matches_Game;

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
            int M = cin.nextInt();
            int piles[] = new int[M];
            int sum = 0;
            for (int i = 0; i < M; i++) {
                piles[i] = cin.nextInt();
                sum += piles[i];
            } while (sum != 0 && sum % 2 == 0) {
                sum = 0;
                for (int i = 0; i < M; i++) {
                    piles[i] /= 2;
                    sum += piles[i];
                }
            }
            if (sum == 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
