package P1195__Mobile_phones;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-11-10
 * Time: 0:00:40
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int m[][];

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        m = new int[S + 1][S + 1];
        while (true) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int instruction = Integer.parseInt(st.nextToken());
            if (instruction == 1) {
                int X = Integer.parseInt(st.nextToken()) + 1;
                int Y = Integer.parseInt(st.nextToken()) + 1;
                int A = Integer.parseInt(st.nextToken());
                for (int i = X; i <= S; i += lowbit(i)) {
                    for (int j = Y; j <= S; j += lowbit(j)) {
                        m[i][j] += A;
                    }
                }
            } else if (instruction == 2) {
                int L = Integer.parseInt(st.nextToken()) + 1;
                int B = Integer.parseInt(st.nextToken()) + 1;
                int R = Integer.parseInt(st.nextToken()) + 1;
                int T = Integer.parseInt(st.nextToken()) + 1;
                int result = sum(R, T) - sum(L - 1, T) - sum(R, B - 1) + sum(L - 1, B - 1);
                System.out.println(result);
            } else {
                break;
            }
        }
    }

    static int sum(int X, int Y) {
        int result = 0;
        for (int i = X; i > 0; i -= lowbit(i)) {
            for (int j = Y; j > 0; j -= lowbit(j)) {
                result += m[i][j];
            }
        }
        return result;
    }

    static int lowbit(int number) {
        int result = 1;
        while ((number & result) == 0) {
            result *= 2;
        }
        return result;
    }
}
