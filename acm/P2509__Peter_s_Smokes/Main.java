package P2509__Peter_s_Smokes;

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
        while (cin.hasNextInt() == true) {
            int N = cin.nextInt();
            int K = cin.nextInt();
            int rest = 0;
            int result = 0;
            while (N != 0) {
                result += N;
                rest += N % K;
                N /= K;
                if (rest >= K) {
                    rest -= K;
                    N++;
                }
            }
            System.out.println(result);
        }
    }
}
