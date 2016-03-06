package P1674__Sorting_By_Swapping;

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
            int n = cin.nextInt();
            int permutation[] = new int[n + 1];
            int pos[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int temp = cin.nextInt();
                permutation[i] = temp;
                pos[temp] = i;
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (permutation[i] != i) {
                    pos[permutation[i]] = pos[i];
                    permutation[pos[i]] = permutation[i];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
