package P1218__The_Drunk_Jailer;

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
            int n = cin.nextInt();
            boolean unlocks[] = new boolean[n + 1];
            int result = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    if (unlocks[j] == true) {
                        unlocks[j] = false;
                        result--;
                    }
                    else {
                        unlocks[j] = true;
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
