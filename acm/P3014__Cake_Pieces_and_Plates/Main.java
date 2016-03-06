package P3014__Cake_Pieces_and_Plates;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-26
 * Time: 6:00:02
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int ways[] = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            ways[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int temp[] = new int[m + 1];
            for (int j = 0; j <= m; j++) {
                temp[j] = ways[j];
                if (j >= i) {
                    temp[j] = (temp[j] + temp[j - i]) % 1000000007;
                }
            }
            ways = temp;
        }
        System.out.println(ways[m]);
    }
}
