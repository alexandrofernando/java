package P2738__Two_Ends;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-8
 * Time: 22:56:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int cards[];
    static int max[][];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = in.nextInt();
            }
            max = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                max[i][i + 1] = cards[i];
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j + i <= n; j++) {
                    int temp1 = cards[j] + search(j + 1, j + i);
                    int temp2 = search(j, j + i - 1) + cards[j + i - 1];
                    max[j][j + i] = Math.max(temp1, temp2);
                }
            }
            System.out.println("In game " + test + ", the greedy strategy might lose by as many as " + max[0][n] + " points.");
            test++;
        }
    }

    static int search(int start, int end) {
        if (cards[start] >= cards[end - 1]) {
            return -cards[start] + max[start + 1][end];
        } else {
            return max[start][end - 1] - cards[end - 1];
        }
    }
}
