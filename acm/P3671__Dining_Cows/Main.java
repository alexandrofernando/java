package P3671__Dining_Cows;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-11
 * Time: 0:09:49
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
        int front2[] = new int[N + 1];
        int count = 0;
        for (int i = 0; i <= N; i++) {
            front2[i] = count;
            if (i < N && cards[i] == 2) {
                count++;
            }
        }
        int back1[] = new int[N + 1];
        count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (cards[i] == 1) {
                count++;
            }
            back1[i] = count;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            min = Math.min(min, front2[i] + back1[i]);
        }
        System.out.println(min);
    }
}