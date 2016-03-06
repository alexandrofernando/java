package P2487__Stamps;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
            int need = cin.nextInt();
            int friend = cin.nextInt();
            int stamps[] = new int[friend];
            for (int i = 0; i < friend; i++) {
                stamps[i] = cin.nextInt();
            }
            Arrays.sort(stamps);
            System.out.println("Scenario #" + t + ":");
            int sum = 0;
            for (int i = friend - 1; i >= 0; i--) {
                sum += stamps[i];
                if (sum >= need) {
                    System.out.println(friend - i);
                    break;
                }
            }
            if (sum < need) {
                System.out.println("impossible");
            }
            System.out.println();
        }
    }
}
