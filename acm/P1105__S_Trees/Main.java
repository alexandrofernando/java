package P1105__S_Trees;

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
    static int n;
    static int order[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        do {
            n = cin.nextInt();
            if (n == 0) {
                break;
            }
            order = new int[n];
            for (int i = 0; i < n; i++) {
                order[i] = cin.next().charAt(1) - '0' - 1;
            }
            String nodes = cin.next();
            System.out.println("S-Tree #" + test + ":");
            test++;
            int m = cin.nextInt();
            for (int i = 0; i < m; i++) {
                System.out.print(search(cin.next(), 0, nodes));
            }
            System.out.println();
            System.out.println();
        }
        while (true);
    }

    static char search(String VVA, int depth, String nodes) {
        if (depth == n) {
            return nodes.charAt(0);
        }
        else {
            char ch = VVA.charAt(order[depth]);
            int length = nodes.length();
            if (ch == '0') {
                return search(VVA, depth + 1,
                              nodes.substring(0, (length + 1) / 2));
            }
            else {
                return search(VVA, depth + 1,
                              nodes.substring( (length + 1) / 2, length));
            }
        }
    }
}
