package P3268__Silver_Cow_Party;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-8
 * Time: 1:56:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int N;
    static int X;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int M = in.nextInt();
        X = in.nextInt() - 1;
        int times1[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    times1[i][j] = 0;
                } else {
                    times1[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            int A = in.nextInt() - 1;
            int B = in.nextInt() - 1;
            int T = in.nextInt();
            times1[A][B] = Math.min(times1[A][B], T);
        }
        int to[] = dijkstra(times1);
        int times2[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                times2[i][j] = times1[j][i];
            }
        }
        int back[] = dijkstra(times2);
        int max = -1;
        for (int i = 0; i < N; i++) {
            if (to[i] + back[i] > max) {
                max = to[i] + back[i];
            }
        }
        System.out.println(max);
    }

    static int[] dijkstra(int times[][]) {
        int results[] = new int[N];
        for (int i = 0; i < N; i++) {
            results[i] = Integer.MAX_VALUE;
        }
        boolean visited[] = new boolean[N];
        results[X] = 0;
        visited[X] = true;
        int previous = X;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[j] == false && times[previous][j] != Integer.MAX_VALUE) {
                    if (results[previous] + times[previous][j] < results[j]) {
                        results[j] = results[previous] + times[previous][j];
                    }
                }
            }
            previous = -1;
            for (int j = 0; j < N; j++) {
                if (visited[j] == false && (previous == -1 || results[j] < results[previous])) {
                    previous = j;
                }
            }
            visited[previous] = true;
        }
        return results;
    }
}
