package P1651__Multiplication_Puzzle;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-6
 * Time: 2:59:44
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int cards[] = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = in.nextInt();
        }
        int scores[][] = new int[N - 1][N - 1];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                scores[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= N - 2; i++) {
            for (int j = 0; j + i < N - 1; j++) {
                for (int k = j; k < j + i; k++) {
                    scores[j][j + i] = Math.min(scores[j][j + i], scores[j][k] + scores[k + 1][j + i] + cards[j] * cards[k + 1] * cards[j + i + 1]);
                }
            }
        }
        System.out.println(scores[0][N - 2]);
    }
}
