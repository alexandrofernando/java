package P2291__Rotten_Ropes;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
            int ropes[] = new int[n];
            for (int i = 0; i < n; i++) {
                ropes[i] = cin.nextInt();
            }
            Arrays.sort(ropes);
            int result = 0;
            for (int i = 0; i < n; i++) {
                int temp = (n - i) * ropes[i];
                if (temp > result) {
                    result = temp;
                }
            }
            System.out.println(result);
        }
    }
}
