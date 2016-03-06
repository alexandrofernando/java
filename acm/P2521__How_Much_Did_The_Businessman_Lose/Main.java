package P2521__How_Much_Did_The_Businessman_Lose;

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
            int N = cin.nextInt();
            int M = cin.nextInt();
            int P = cin.nextInt();
            int C = cin.nextInt();
            if (N == 0 && M == 0 && P == 0 && C == 0) {
                break;
            }
            System.out.println(N + P - M);
        }
        while (true);
    }
}
