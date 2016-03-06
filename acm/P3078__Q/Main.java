package P3078__Q;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 6:26:19
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int m = in.nextInt();
            int n = in.nextInt();
            String queue[] = new String[m];
            for (int i = 0; i < m; i++) {
                queue[i] = in.next();
            }
            boolean moves[] = new boolean[m];
            String result[] = new String[m];
            for (int i = 0; i < n; i++) {
                int starting = in.nextInt() - 1;
                int requested = in.nextInt() - 1;
                moves[starting] = true;
                result[requested] = queue[starting];
            }
            int pos = 0;
            for (int i = 0; i < m; i++) {
                if (result[i] == null) {
                    while (moves[pos] == true) {
                        pos++;
                    }
                    result[i] = queue[pos];
                    pos++;
                }
            }
            for (int i = 0; i < m; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
}
