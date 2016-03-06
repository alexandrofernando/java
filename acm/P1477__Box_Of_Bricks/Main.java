package P1477__Box_Of_Bricks;

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
        int test = 1;
        while (true) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            int heights[] = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                heights[i] = cin.nextInt();
                sum += heights[i];
            }
            int average = sum / n;
            int moves = 0;
            for (int i = 0; i < n; i++) {
                if (heights[i] > average) {
                    moves += heights[i] - average;
                }
            }
            System.out.println("Set #" + test);
            test++;
            System.out.println("The minimum number of moves is " + moves + ".");
            System.out.println();
        }
    }
}
