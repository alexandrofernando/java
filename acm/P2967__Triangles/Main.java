package P2967__Triangles;

import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-13
 * Time: 17:34:09
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        line = stdin.readLine();
        st = new StringTokenizer(line);
        long lengths[] = new long[N];
        for (int i = 0; i < N; i++) {
            lengths[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(lengths);
        boolean result = true;
        if (N < 3 || lengths[0] + lengths[1] > lengths[N - 1]) {
            result = false;
        } else {
            result = false;
            for (int i = 0; i < N - 2; i++) {
                if (lengths[i] + lengths[i + 1] > lengths[i + 2]) {
                    result = true;
                    break;
                }
            }
        }
        if (result == true) {
            System.out.println("The set is accepted.");
        } else {
            System.out.println("The set is rejected.");
        }
    }
}
