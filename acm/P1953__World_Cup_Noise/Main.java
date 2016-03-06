package P1953__World_Cup_Noise;

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
        int numbers[][] = new int[45][2];
        numbers[1][0] = 1;
        numbers[1][1] = 1;
        for (int i = 2; i < 45; i++) {
            numbers[i][0] = numbers[i - 1][0] + numbers[i - 1][1];
            numbers[i][1] = numbers[i - 1][0];
        }
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            System.out.println("Scenario #" + t + ":");
            System.out.println(numbers[n][0] + numbers[n][1]);
            System.out.println();
        }
    }
}
