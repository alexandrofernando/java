package P2350__Above_Average;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            int grades[] = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                grades[i] = cin.nextInt();
                sum += grades[i];
            }
            int above = 0;
            for (int i = 0; i < N; i++) {
                if (grades[i] * N > sum) {
                    above++;
                }
            }
            System.out.printf("%.3f%%\n", 100.0 * above / N);
        }
    }
}
