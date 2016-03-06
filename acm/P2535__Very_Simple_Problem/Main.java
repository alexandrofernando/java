package P2535__Very_Simple_Problem;

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
        int N = cin.nextInt();
        int P = cin.nextInt();
        int counts[] = new int[P];
        boolean hardest[] = new boolean[P];
        for (int i = 0; i < N; i++) {
            int ratings[] = new int[P];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < P; j++) {
                ratings[j] = cin.nextInt();
                if (ratings[j] < min) {
                    min = ratings[j];
                }
                if (ratings[j] > max) {
                    max = ratings[j];
                }
            }
            for (int j = 0; j < P; j++) {
                if (ratings[j] == min) {
                    counts[j]++;
                }
                if (ratings[j] == max) {
                    hardest[j] = true;
                }
            }
        }
        boolean exist = false;
        for (int i = 0; i < P; i++) {
            if (counts[i] * 2 > N && hardest[i] == false) {
                if (exist == true) {
                    System.out.print(" ");
                }
                System.out.print(i + 1);
                exist = true;
            }
        }
        if (exist == false) {
            System.out.print(0);
        }
        System.out.println();
    }
}
