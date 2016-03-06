package P3318__Matrix_Multiplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 6:41:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        n = Integer.parseInt(st.nextToken());
        int A[][] = new int[n][n];
        int B[][] = new int[n][n];
        int C[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
                C[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean equal = true;
        for (int i = 0; i < 10; i++) {
            int X[] = new int[n];
            for (int j = 0; j < n; j++) {
                X[j] = (int) (Math.random() * 200) - 100;
            }
            int left[] = multiply(A, multiply(B, X));
            int right[] = multiply(C, X);
            for (int j = 0; j < n; j++) {
                if (left[j] != right[j]) {
                    equal = false;
                    break;
                }
            }
            if (equal == false) {
                break;
            }
        }
        if (equal == true) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static int[] multiply(int x[][], int y[]) {
        int z[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                z[i] += x[i][j] * y[j];
            }
        }
        return z;
    }
}
