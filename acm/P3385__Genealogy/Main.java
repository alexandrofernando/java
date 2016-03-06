package P3385__Genealogy;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-6
 * Time: 22:34:25
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        line = stdin.readLine();
        st = new StringTokenizer(line);
        int counts[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            counts[Integer.parseInt(st.nextToken())]++;
        }
        int result = 0;
        for (int i = 0; i < n + 1; i++) {
            while (counts[i] > d) {
                int temp = counts[i] / d;
                result += temp;
                counts[i] = temp + counts[i] % d;
            }
        }
        System.out.println(result);
    }
}
