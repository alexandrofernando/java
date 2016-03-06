package P2533__Longest_Ordered_Subsequence;

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
        int numbers[] = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = cin.nextInt();
        }
        int lengths[] = new int[N];
        for (int i = 0; i < N; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && lengths[j] + 1 > lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (lengths[i] > max) {
                max = lengths[i];
            }
        }
        System.out.println(max);
    }
}
