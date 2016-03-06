package P2456__Aggressive_cows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 22:06:17
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int positions[] = new int[N];
        for (int i = 0; i < N; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            positions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(positions);
        int bottom = 1;
        int top = positions[N - 1] - positions[0];
        int max = -1;
        while (bottom <= top) {
            int middle = (bottom + top) / 2;
            boolean valid = true;
            int previous = 0;
            for (int i = 1; i < C; i++) {
                boolean find = false;
                for (int j = previous + 1; j < N; j++) {
                    if (positions[j] - positions[previous] >= middle) {
                        find = true;
                        previous = j;
                        break;
                    }
                }
                if (find == false) {
                    valid = false;
                    break;
                }
            }
            if (valid == true) {
                if (middle > max) {
                    max = middle;
                }
                bottom = middle + 1;
            } else {
                top = middle - 1;
            }
        }
        System.out.println(max);
    }
}
