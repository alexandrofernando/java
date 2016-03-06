package P1978__Hanafuda_Shuffle;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-19
 * Time: 7:10:59
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int r = in.nextInt();
            if (n == 0 && r == 0) {
                break;
            }
            int cards[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                cards[i] = n + 1 - i;
            }
            for (int i = 0; i < r; i++) {
                int p = in.nextInt();
                int c = in.nextInt();
                int temp[] = new int[n + 1];
                for (int j = 1; j <= c; j++) {
                    temp[j] = cards[p + j - 1];
                }
                for (int j = c + 1; j <= p + c - 1; j++) {
                    temp[j] = cards[j - c];
                }
                for (int j = p + c; j <= n; j++) {
                    temp[j] = cards[j];
                }
                cards = temp;
            }
            System.out.println(cards[1]);
        }
    }
}
