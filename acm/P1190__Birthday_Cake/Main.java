package P1190__Birthday_Cake;

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
    static int N;
    static int M;
    static int S;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        M = cin.nextInt();
        S = Integer.MAX_VALUE;
        for (int r1 = M; r1 * r1 * M <= N; r1++) {
            for (int h1 = M; r1 * r1 * h1 <= N; h1++) {
                search(1, r1, h1, r1 * r1 * h1, r1 * r1 + 2 * r1 * h1);
            }
        }
        System.out.println(S);
    }

    static void search(int depth, int R, int H, int T, int W) {
        if (depth == M) {
            if (T == N && W < S) {
                S = W;
            }
            return;
        }
        if (T > N || W > S) {
            return;
        }
        int tempT = T;
        for (int i = R - 1; i > R - 1 - (M - depth); i--) {
            tempT += i * i * i;
        }
        if (tempT < N) {
            return;
        }
        tempT = T;
        int tempW = W;
        for (int i = 1; i <= M - depth; i++) {
            tempT += i * i * i;
            tempW += 2 * i * i;
        }
        if (tempT > N || tempW > S) {
            return;
        }
        if (2.0 * (N - T) / R > S - W) {
            return;
        }
        for (int r = R - 1; r >= M - depth; r--) {
            for (int h = H - 1; h >= M - depth; h--) {
                search(depth + 1, r, h, T + r * r * h, W + 2 * r * h);
            }
        }
    }
}
