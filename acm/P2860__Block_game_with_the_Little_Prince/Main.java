package P2860__Block_game_with_the_Little_Prince;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 21:29:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int initial[] = new int[K];
        for (int i = 0; i < K; i++) {
            initial[i] = in.nextInt();
        }
        int target[] = new int[K];
        for (int i = 0; i < K; i++) {
            target[i] = in.nextInt();
        }
        int move = 0;
        for (int i = 0; i < K; i++) {
            if (target[i] > initial[i]) {
                move += target[i] - initial[i];
            }
        }
        System.out.println(move);
    }
}
