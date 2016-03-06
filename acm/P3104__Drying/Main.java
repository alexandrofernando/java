package P3104__Drying;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-27
 * Time: 5:46:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        int top = 0;
        line = stdin.readLine();
        st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] > top) {
                top = a[i];
            }
        }
        line = stdin.readLine();
        st = new StringTokenizer(line);
        int K = Integer.parseInt(st.nextToken());
        if (K == 1) {
            System.out.println(top);
        } else {
            int result = -1;
            int bottom = 1;
            while (bottom <= top) {
                int middle = (bottom + top) / 2;
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i] > middle) {
                        count += Math.ceil((a[i] - middle) / (K - 1.0));
                        if (count > middle) {
                            break;
                        }
                    }
                }
                if (count <= middle) {
                    result = middle;
                    top = middle - 1;
                } else {
                    bottom = middle + 1;
                }
            }
            System.out.println(result);
        }
    }
}
