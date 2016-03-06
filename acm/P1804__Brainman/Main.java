package P1804__Brainman;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            int numbers[] = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = cin.nextInt();
            }
            int swap = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (numbers[i] > numbers[j]) {
                        swap++;
                    }
                }
            }
            System.out.println("Scenario #" + t + ":");
            System.out.println(swap);
            System.out.println();
        }
    }
}
