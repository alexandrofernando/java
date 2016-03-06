package P3213__PM3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 17:23:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[][] = new int[N][P];
        int B[][] = new int[P][M];
        int C[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < P; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < P; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < M; j++) {
                C[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int vector1[] = new int[M];
        for (int i = 0; i < M; i++) {
            vector1[i] = 1;
        }
        int columnLeft[] = multiply(A, multiply(B, vector1));
        int columnRight[] = multiply(C, vector1);
        int r = -1;
        for (int i = 0; i < N; i++) {
            if (columnLeft[i] != columnRight[i]) {
                r = i;
                break;
            }
        }
        if (r == -1) {
            System.out.println("Yes");
        } else {
            int vector2[] = new int[N];
            for (int i = 0; i < N; i++) {
                vector2[i] = 1;
            }
            int rowLeft[] = multiply(multiply(vector2, A), B);
            int rowRight[] = multiply(vector2, C);
            int c = -1;
            for (int i = 0; i < M; i++) {
                if (rowLeft[i] != rowRight[i]) {
                    c = i;
                    break;
                }
            }
            int v = 0;
            for (int i = 0; i < P; i++) {
                v += A[r][i] * B[i][c];
            }
            System.out.println("No");
            System.out.println((r + 1) + " " + (c + 1));
            System.out.println(v);
        }
    }

    static int[] multiply(int x[][], int y[]) {
        int z[] = new int[x.length];
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < y.length; j++) {
                z[i] += x[i][j] * y[j];
            }
        }
        return z;
    }

    static int[] multiply(int x[], int y[][]) {
        int z[] = new int[y[0].length];
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < x.length; j++) {
                z[i] += x[j] * y[j][i];
            }
        }
        return z;
    }
}
