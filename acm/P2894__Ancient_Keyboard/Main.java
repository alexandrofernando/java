package P2894__Ancient_Keyboard;

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
            int counts[] = new int[1001];
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                cin.next();
                int a = cin.nextInt();
                int b = cin.nextInt();
                for (int j = a; j < b; j++) {
                    counts[j]++;
                }
            }
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    System.out.print((char) (counts[i] + 'A' - 1));
                }
            }
            System.out.println();
        }
    }
}
