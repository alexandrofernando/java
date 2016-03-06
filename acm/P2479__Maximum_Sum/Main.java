package P2479__Maximum_Sum;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.
                in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int test = Integer.parseInt(st.nextToken());
        stdin.readLine();
        for (int t = 1; t <= test; t++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int numbers[] = new int[N + 1];
            int frontMaxs[] = new int[N + 2];
            int rearMaxs[] = new int[N + 2];
            frontMaxs[0] = Integer.MIN_VALUE;
            rearMaxs[N + 1] = Integer.MIN_VALUE;
            line = stdin.readLine();
            st = new StringTokenizer(line);
            for (int i = 1; i <= N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                if (sum > 0) {
                    sum += numbers[i];
                } else {
                    sum = numbers[i];
                }
                if (sum > max) {
                    max = sum;
                }
                frontMaxs[i] = max;
            }
            sum = 0;
            max = Integer.MIN_VALUE;
            for (int i = N; i > 1; i--) {
                if (sum > 0) {
                    sum += numbers[i];
                } else {
                    sum = numbers[i];
                }
                if (sum > max) {
                    max = sum;
                }
                rearMaxs[i] = max;
            }
            int S = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                if (frontMaxs[i] + rearMaxs[i + 1] > S) {
                    S = frontMaxs[i] + rearMaxs[i + 1];
                }
            }
            System.out.println(S);
            stdin.readLine();
        }
    }
}
