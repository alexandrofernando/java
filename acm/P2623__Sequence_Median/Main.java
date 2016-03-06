package P2623__Sequence_Median;

import java.util.Arrays;
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
        int N = Integer.parseInt(st.nextToken());
        long numbers[] = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            numbers[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(numbers, 1, N + 1);
        if (N % 2 == 1) {
            System.out.printf("%.1f\n", (double) numbers[(N + 1) / 2]);
        } else {
            System.out.printf("%.1f\n",
                              (numbers[N / 2] + numbers[N / 2 + 1]) / 2.0);
        }
    }
}
